package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nino Bonev - 4.8.2018 г., 12:28
 */
public class VehicleAssemblerTest {
    private VehicleAssembler vehicleAssembler;
    private DefenseModifyingPart defenseModifyingPart;
    private AttackModifyingPart attackModifyingPart;
    private HitPointsModifyingPart hitPointsModifyingPart;

    @org.junit.Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
    }

    @org.junit.Test
    public void getTotalWeight() {
        //Arrange
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(30.0);
        //Act
        double actualWeight = this.vehicleAssembler.getTotalWeight();
        double expectedTotalWeight = 60.0;
        //Assert
        Assert.assertEquals(expectedTotalWeight, actualWeight, 0.1);
    }

    @org.junit.Test
    public void getTotalPrice() {
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.valueOf(100));
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(BigDecimal.valueOf(200));
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.valueOf(3000));
        //Act
        BigDecimal actualPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(3300);
        //Assert
        Assert.assertEquals(0, actualPrice.compareTo(expectedTotalPrice));
    }

    @org.junit.Test
    public void getTotalAttackModification() {
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(201);

        Long actualAttackingModification = this.vehicleAssembler.getTotalAttackModification();
        Long expectedAttackingModification = 201L;

        Assert.assertEquals(expectedAttackingModification, actualAttackingModification, 0.1);
    }

    @org.junit.Test
    public void getTotalDefenseModification() {
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(201);

        Long actualDefenseModifier = this.vehicleAssembler.getTotalDefenseModification();
        Long expectedDefenseModifier = 201L;

        Assert.assertEquals(expectedDefenseModifier, actualDefenseModifier, 0.1);
    }

    @org.junit.Test
    public void getTotalHitPointModification() {
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(201);

        Long actualHitPointsModifier = this.vehicleAssembler.getTotalHitPointModification();
        Long expectedHitPointsModifier = 201L;

        Assert.assertEquals(expectedHitPointsModifier, actualHitPointsModifier, 0.1);
    }

    @org.junit.Test
    public void addArsenalPart() {
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part3 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part3.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);
        assembler.addArsenalPart(part3);

        long actualAttackModification = assembler.getTotalAttackModification();
        long expectedAttackModification = (long) Integer.MAX_VALUE * 3;

        Assert.assertEquals(expectedAttackModification, actualAttackModification);
    }

    @org.junit.Test
    public void addShellPart() {
        Assembler assembler = new VehicleAssembler();
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);


        assembler.addShellPart(part1);
        assembler.addShellPart(part2);

        long actualAttackModification = assembler.getTotalDefenseModification();
        long expectedAttackModification = (long)Integer.MAX_VALUE * 2;

        Assert.assertEquals(expectedAttackModification, actualAttackModification);

    }

    @org.junit.Test
    public void addEndurancePart() {
        Assembler assembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addEndurancePart(part1);
        assembler.addEndurancePart(part2);

        long actualAttackModification = assembler.getTotalHitPointModification();
        long expectedAttackModification = (long) Integer.MAX_VALUE * 2;

        Assert.assertEquals(expectedAttackModification, actualAttackModification);
    }
}