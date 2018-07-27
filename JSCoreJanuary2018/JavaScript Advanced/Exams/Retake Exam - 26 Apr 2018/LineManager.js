class LineManager {

    constructor(arr) {
        this.stops = arr;
        this.currentStop = 0;
        this.dealy = 0;
        this.duration = 0;
    }

    get stops(){
        return this._stops;
    }

    set stops(arr){
        for (let stop of arr) {
            if (typeof stop.name !== "string" || stop.name.length === 0){
                throw new Error("Stop name should be non-empty string.")
            }
            if (typeof stop.timeToNext !== "number" || stop.timeToNext < 0){
                throw new Error("Time should be positive number.")
            }
            this._stops = arr;
        }
    }

    get atDepot(){
        return this._stops.length - 1 === this.currentStop;
    }

    get nextStopName(){
        if (this.atDepot){
            return "At depot.";
        } else {
            return this._stops[this.currentStop + 1].name;
        }
    }

    get currentDelay(){
        return this.dealy;
    }

    arriveAtStop(minutes){
        if (minutes < 0){
            throw new Error("minutes cannot be negative")
        } 
        if (this.atDepot) {
            throw new Error("last stop reached")
        }
        this.dealy += minutes - this._stops[this.currentStop].timeToNext;
        this.duration += minutes;
        this.currentStop++;
        return !this.atDepot;
    }

    toString(){
        let result = 'Line summary\n';
        if (this.atDepot) {
            result += `- Course completed\n`;
        } else {
            result += `- Next stop: ${this._stops[this.currentStop + 1].name}\n`;
        }
        result += `- Stops covered: ${this.currentStop}\n`;
        result += `- Time on course: ${this.duration} minutes\n`;
        result += `- Delay: ${this.currentDelay} minutes\n`;

        return result.trim();
    }
}

const wrong = new LineManager([
    { name: 'Stop', timeToNext: { wrong: 'Should be a number'} }
]);


