// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import subsystem in Constants 
import static  frc.robot.Constants.Subsystem.*;

public class Trapper extends SubsystemBase {
  /** Creates a new Intake. */
  public WPI_VictorSPX TrapDoor  = new WPI_VictorSPX (TRAPDOOR_ID);
  
  public Trapper() {
    TrapDoor.setNeutralMode(NeutralMode.Brake);
  }

  public void intake (double speed) {
    TrapDoor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}