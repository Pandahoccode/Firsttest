// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

// https://www.kauailabs.com/dist/frc/2022/navx_frc.json
// https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix-frc2022-latest.json

public final class Constants {
    // Final class Subsystem 
    public static final class Subsystem {
       public static final int RM_MOTOR_ID = 1;
       public static final int LM_MOTOR_ID = 2;
       public static final int RF_MOTOR_ID = 3;    
       public static final int LF_MOTOR_ID = 4;
       public static final int SUCK_MOTOR_ID = 5;
       public static final int ELEVATOR_1_ID = 6;
       public static final int ELEVATOR_2_ID = 7;
       public static final int TRAPDOOR_ID = 8;
    }

    // Final class Joystick button

   public static final class Joystick_Button {
       public static final int A_BUTTON = 1;
       public static final int B_BUTTON = 2;
       public static final int X_BUTTON = 3;
       public static final int Y_BUTTON = 4;
       public static final int Left_Bumper = 5;
       public static final int Right_Bumper = 6;
       public static final int START_BUTTON = 8;
       public static final int Left_Stick = 9;
       public static final int Right_Stick = 10;
   }

    // Final class Joystick Axis
    public static final class Joystick_Axis {
        public static final int Left_Stick_X =  0;
        public static final int Left_Stick_Y =  1;
        public static final int Right_Stick_X = 4;
        public static final int Right_Stick_Y = 5;
        public static final int Left_Trigger =  2;
        public static final int Right_Trigger = 3;
    }

    // Final class Speed 
    public static final class Speed {
        public static final double V_FAST = 0.8; 
        public static final double V_NORMAL = 0.4;
        public static final double V_LOW = 0.2;  
        public static final double V_INTAKE = 0.7;
        public static final double V_ELEVATOR = 0.5;
        public static final double V_NULL = 0;
   }
}
