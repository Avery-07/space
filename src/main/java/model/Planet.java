package model;

import java.util.ArrayList;
import java.util.List;

public class Planet extends CelestialBody {
    private int ownerID; // 0 for neutral, or Player ID
    private int totalSlots;
    private List<BuildingSlot> slots;

    // Abstracted Stats
    private double massResources;     // Resource multiplier
    private double solarEnergyFactor; // How much energy it generates (Distance from star)

    public Planet(String name, double distance, double period, int slotsCount) {
        super(name, distance, period);
        this.totalSlots = slotsCount;
        this.slots = new ArrayList<>(slotsCount);

        // Initialize empty slots
        for (int i = 0; i < slotsCount; i++) {
            slots.add(new BuildingSlot());
        }
    }
}