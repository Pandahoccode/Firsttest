// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Sucker;
import static frc.robot.Constants.Speed.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto extends SequentialCommandGroup {
  /** Creates a new auto. */
  public Auto(Drivebase db, Sucker in, Elevator elevator) {
    addCommands(new DriveStraight(db, -0.7).withTimeout(5));

    //addCommands(new DriveStraight(db, V_NORMAL).withTimeout(5);
  }
}
