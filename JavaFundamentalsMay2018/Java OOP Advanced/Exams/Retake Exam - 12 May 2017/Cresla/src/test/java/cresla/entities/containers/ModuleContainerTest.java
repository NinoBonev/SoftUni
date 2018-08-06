package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

/**
 * Created by Nino Bonev - 4.8.2018 г., 14:53
 */
public class ModuleContainerTest {
    private final int MODULE_CAPACITY = 3;
    private Container container;

    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;
    private EnergyModule energyModule3;
    private EnergyModule energyModule4;

    @org.junit.Before
    public void setUp() throws Exception {
        this.container = new ModuleContainer(MODULE_CAPACITY);

        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        this.energyModule3 = Mockito.mock(EnergyModule.class);
        this.energyModule4 = Mockito.mock(EnergyModule.class);

        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(absorbingModule1.getId()).thenReturn(1);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(absorbingModule2.getId()).thenReturn(2);

        Mockito.when(energyModule3.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(energyModule3.getId()).thenReturn(3);
        Mockito.when(energyModule4.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(energyModule4.getId()).thenReturn(4);
    }

    @org.junit.Test
    public void classShouldRemoveFirstModuleWhenCapacityReached() {
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addEnergyModule(this.energyModule4);
        this.container.addEnergyModule(this.energyModule3);

        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
        Assert.assertEquals((long) Integer.MAX_VALUE * 2, this.container.getTotalEnergyOutput());
    }

    @org.junit.Test
    public void getTotalHeatAbsorbingOnEmptyCollection() throws Exception {
        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
    }

    @org.junit.Test
    public void getTotalEnergyOutputOnEmptyCollection() throws Exception {
        Assert.assertEquals(0, this.container.getTotalEnergyOutput());
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void addModuleOnEmptyContainerShouldThrowEx() throws Exception {
        Container container1 = new ModuleContainer(0);
        container1.addAbsorbingModule(this.absorbingModule2);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleWithNullValueShouldThrowException() {
        this.container.addEnergyModule(null);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleWithNullValueShouldThrowException() {
        this.container.addAbsorbingModule(null);
    }

    @org.junit.Test
    public void addEnergyModule() {
        this.container.addEnergyModule(energyModule3);
        this.container.addEnergyModule(energyModule4);

        Long actualEnergy = this.container.getTotalEnergyOutput();
        Long expectedEnergy = (long) Integer.MAX_VALUE * 2;

        Assert.assertEquals(expectedEnergy, actualEnergy);
    }

    @org.junit.Test
    public void addAbsorbingModule() {
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);

        Long actualEnergy = this.container.getTotalHeatAbsorbing();
        Long expectedEnergy = (long) Integer.MAX_VALUE * 2;

        Assert.assertEquals(expectedEnergy, actualEnergy);
    }

    @org.junit.Test
    public void getTotalEnergyOutput() throws Exception {
        this.container.addEnergyModule(energyModule4);
        this.container.addEnergyModule(energyModule3);
        Assert.assertEquals((long) Integer.MAX_VALUE * 2, this.container.getTotalEnergyOutput());
    }

    @org.junit.Test
    public void getTotalHeatAbsorbing() throws Exception {
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);
        Assert.assertEquals((long) Integer.MAX_VALUE * 2, this.container.getTotalHeatAbsorbing());
    }
}