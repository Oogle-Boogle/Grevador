package ethos.model.content.interfaces;

import ethos.model.npcs.NPCDef;
import org.necrotic.client.cache.definition.Animation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * This file contains the header, definitions and animation calculation for the Pet System
 * version 1.0 created on 11/12/2015, basic class
 * version 1.1 created on 11/15/2015, upgraded to read from the whole model array
 * version 1.2 created on 11/16/2015, upgraded to use the real animation delays
 */


/**
 *
 * @author Near Reality
 * @author Nucleon
 * @version 1.2
 *
 */


public class PetSystem {


    /**
     * @param modelArray
     * @param entity Use EntityDef.forID() to insert the ID of the Pet.
     */
    public PetSystem(int[] modelArray, NPCDef entity) {
        this.modelArray = modelArray;
        modelArrayLength = getModelArrayLength();
        this.name = entity.npcName;
        animation = entity.attackEmote;
        animationDelay = Animation.cache[animation].delays[animationFrame];
    }

    private final int[] modelArray;

    private int[] getModelArray() {
        return modelArray;
    }

    public static void petAnimationStep() {
        if (updatePetAnimations) {
            return;
        }
        animationFrame++;
        if (animationFrame >= Animation.cache[animation].frameIDs.length) {
            animationFrame = 0;
        }
    }


    public static void updateAnimations() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                isPetAnimationRunning = true;
                petAnimationStep();
            }
        }, 0, (animationDelay == 0) ? 100 : animationDelay * 100 , TimeUnit.MILLISECONDS);


    }


    public int getAnimationDelay() {
        return animationDelay;
    }


    public int getAnimation() {
        return animation;
    }


    public String getName() {
        return name;
    }


    public int getAnimationFrame() {
        return animationFrame;
    }


    public int getModelArrayLength() {
        return modelArrayLength;
    }

    public int getPetSelected() {
        return petSelected;
    }
    public void setPetSelected(int petID) {
        petSelected = petID;
    }
    /**
     * The length of the model container.
     */
    private final int modelArrayLength;
    /**
     * The name of the pet.
     */
    private final String name;
    /**
     * The description of the pet.
     */
    /**
     * The default animation of the pet.
     */
    private static int animation;
    /**
     * The default animation delay of the animation frame's.
     */
    private static int animationDelay;
    /**
     * The current index in the animation array.
     */
    public static int animationFrame;
    /**
     * This boolean will prevent the pet animation from looping.
     */
    public static boolean updatePetAnimations = false;
    /**
     * Checks if the pet animation is currently lopping.
     */
    public static boolean isPetAnimationRunning = false;
    /**
     * The current pet your player has following you.
     */
    public static int petSelected = 6260;


}