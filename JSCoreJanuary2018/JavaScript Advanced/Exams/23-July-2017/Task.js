class Task {
    constructor(title, deadline){
        this.title = title;
        this.status = "Open";
        this.deadline = deadline;
    }


    get deadline() {
        return this._deadline;
    }

    set deadline(value) {
        if (Date.now() > value){
            throw new Error("Invalid Date")
        }
        this._deadline = value;
    }

    get isOverdue(){
        return Date.now() > this.deadline;
    }

    get taskLevelSet(){
        if (this.isOverdue && this.status !== "Complete") {
            return 0;
        } else if (this.status === "In Progress") {
            return 1;
        } else if (this.status === "Open") {
            return 2;
        } else {
            return 3;
        }
    }

    static comparator(a, b){
        let result = a.taskLevelSet - b.taskLevelSet;

        if (result === 0) {
            return a._deadline - b._deadline;
        }
        return result;
    }

    get icon() {
        let icon = "";
        this.status === "Open" ? icon = "\u2731" :
            this.status === "In Progress" ? icon = "\u219D" :
                this.status === "Complete" ? icon = "\u2714" :
                    icon = "\u26A0";
        return icon;
    }

    toString(){
        if (this.isOverdue && this.status !== "Complete") {
            return `[${this.icon}] ${this.title} (overdue)`
        } else if (this.isOverdue && this.status === "Complete") {
            return `[${this.icon}] ${this.title}`
        } else {
            return `[${this.icon}] ${this.title} {(deadline: ${this._deadline.toString()})}`
        }
    }
}

let date1 = new Date();
date1.setDate(date1.getDate() + 7); // Set date 7 days from now
let task1 = new Task('JS Homework', date1);
let date2 = new Date();
date2.setFullYear(date2.getFullYear() + 1); // Set date 1 year from now
let task2 = new Task('Start career', date2);
console.log(task1 + '\n' + task2);
let date3 = new Date();
date3.setDate(date3.getDate() + 3); // Set date 3 days from now
let task3 = new Task('football', date3);
// Create two tasks with deadline set to current time
let task4 = new Task('Task 4', new Date());
let task5 = new Task('Task 5', new Date());
task1.status = 'In Progress';
task3.status = 'In Progress';
task5.status = "Complete";
let tasks = [task1, task2, task3, task4, task5];
setTimeout(() => {
    tasks.sort(Task.comparator);
    console.log(tasks.join('\n'));
}, 1000); // Sort and print one second later

// // should throw an Error
// let overdueTask = new Task('Overdue Task', new Date(2005, '4', '20'));
////should throw an Error
//task1.deadline = new Date(2005, '4', '20');
