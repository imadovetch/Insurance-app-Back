package com.programming.techie.Services;

public class CalculedeAssurance {

    // Method to calculate the monthly premium for automobile insurance
    public double calculateAutoInsurance(double age, String vehicleType, String vehicleUsage, boolean hasAccidentsLast3Years) {
        double base = 500.0; // Base price for automobile insurance
        double premium = base;

        // Age factor
        if (age < 25) {
            premium += 50; // +10% of 500 MAD
        }

        // Vehicle type factor
        if (vehicleType.equalsIgnoreCase("luxe")) {
            premium += 75; // +15% of 500 MAD
        }

        // Vehicle usage factor
        if (vehicleUsage.equalsIgnoreCase("professionnel")) {
            premium += 50; // +10% of 500 MAD
        }

        // Accident history factor
        if (!hasAccidentsLast3Years) {
            premium -= 100; // -20% of 500 MAD
        } else {
            premium += 50; // +10% of 500 MAD
        }

        return premium;
    }

    // Method to calculate the monthly premium for home insurance
    public double calculateHomeInsurance(double propertyValue, String propertyType, boolean inRiskArea, boolean hasSecuritySystem) {
        double base = 300.0; // Base price for home insurance
        double premium = base;

        // Property type factor
        if (propertyType.equalsIgnoreCase("maison")) {
            premium += 6; // +2% of 300 MAD
        }

        // Risk area factor
        if (inRiskArea) {
            premium += 15; // +5% of 300 MAD
        }

        // Property value factor
        if (propertyValue > 200_000) {
            premium += 30; // +10% of 300 MAD
        }

        // Security system factor
        if (hasSecuritySystem) {
            premium -= 45; // -15% of 300 MAD
        } else {
            premium += 45; // +15% of 300 MAD
        }

        return premium;
    }
}
