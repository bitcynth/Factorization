package factorization.api.energy;

import java.util.ArrayList;

/**
 * Various general types of energy.
 */
@SuppressWarnings("unused")
public final class EnergyCategory {
    public static final ArrayList<EnergyCategory> VALUES = new ArrayList<EnergyCategory>();

    /**
     * Mass moving in a straight line. Anvils fall; a camshaft drives a reciprocating follower.
     */
    public static final EnergyCategory LINEAR = get("LINEAR");

    /**
     * Mass rotating around a point, typically a center of mass. A waterwheel drives a shaft; gears invert the axis
     * of rotation
     */
    public static final EnergyCategory ROTATIONAL = get("ROTATIONAL");

    /**
     * Energy held in substances that is released under certain conditions, often after some threshold of input energy
     * is breached. Gunpowder can explode; steak can be digested. Uranium and hydrogen can undergo fission or fusion.
     * Sand can hover in the air until a block update causes it to fall.
     * <p/>
     * Not really a unit of energy; more of a unit of storage. Usefully converting chemical energy between other
     * forms tends to be slightly difficult.
     */
    public static final EnergyCategory POTENTIAL = get("POTENTIAL");

    /**
     * Positive pressure, such as from steam and compressed air.
     * The atmosphere is a pressure source to a relative vacuum.
     * Steam drives a piston. Hydrolic oil drives a piston.
     */
    public static final EnergyCategory PRESSURE = get("PRESSURE");

    /**
     * Sub-atomic particles moving at or near the speed of light.
     * Photons, being light/electromagnetic radiation, are here.
     * Also includes protons, electrons, etc.
     */
    public static final EnergyCategory RADIATION = get("RADIATION");

    /**
     * Heat. A byproduct, or sometimes direct product, of many reactions. The fire crackles. Magma rumbles deep
     * in the nether.
     */
    public static final EnergyCategory THERMAL = get("THERMAL");

    /**
     * Electrons moving through, typically, metal wires. Alternating and Direct current. Also includes magnetism.
     * Lightning strikes the ground. The magnet block pulls the door shut.
     */
    public static final EnergyCategory ELECTRIC = get("ELECTRIC");

    /**
     * Redstone signal. Strangely easy to create. Is fundamentally suppressive, but this suppression is often itself
     * suppressed. Receiving a SIGNAL should probably be interpreted as a quick redstone pulse. Implementing this
     * behavior is not at all obligatory, particularly in blocky contexts.
     */
    public static final EnergyCategory SIGNAL = get("SIGNAL");

    /**
     * Periodic motion along an elastic medium. Waves crash against rocks; two tectonic plates slide past
     * one another, producing tremors; the noteblock plays a tone.
     */
    public static final EnergyCategory OSCILLATION = get("OSCILLATION");

    /**
     * Maybe it's sufficiently advanced technology. Maybe it's the eldritch.
     */
    public static final EnergyCategory MAGIC = get("MAGIC");


    public final String name;
    private EnergyCategory(String name) {
        this.name = name;
    }

    public static EnergyCategory get(String name) {
        name = name.intern();
        for (EnergyCategory cat : VALUES) {
            if (cat.name.equals(name)) {
                return cat;
            }
        }
        EnergyCategory ret = new EnergyCategory(name);
        VALUES.add(ret);
        return ret;
    }
}
