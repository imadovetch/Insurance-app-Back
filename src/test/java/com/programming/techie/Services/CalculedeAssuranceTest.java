
package com.programming.techie.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculedeAssuranceTest {

    private CalculedeAssurance assuranceCalculator;

    @BeforeEach
    public void setUp() {
        assuranceCalculator = new CalculedeAssurance();
    }

    @Test
    public void testCalculateAutoInsurance_Under25_Luxury_Professional_Accident() {
        double premium = assuranceCalculator.calculateAutoInsurance(24, "luxe", "professionnel", true);
        assertEquals(725.0, premium, 0.01); // Expected value
    }

    @Test
    public void testCalculateAutoInsurance_Over25_NoAccidents() {
        double premium = assuranceCalculator.calculateAutoInsurance(30, "standard", "privée", false);
        assertEquals(400.0, premium, 0.01); // Expected value
    }

    @Test
    public void testCalculateHomeInsurance_House_InRiskArea_WithSecurity() {
        double premium = assuranceCalculator.calculateHomeInsurance(250_000, "maison", true, true);
        assertEquals(306.0, premium, 0.01); // Expected value
    }

    @Test
    public void testCalculateHomeInsurance_Apartment_NoSecurity_NoRisk() {
        double premium = assuranceCalculator.calculateHomeInsurance(150_000, "appartement", false, false);
        assertEquals(345.0, premium, 0.01); // Expected value
    }
}
