// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import subsystem in Constants
import static frc.robot.Constants.Subsystem.*;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  public static WPI_TalonFX Intake_2 = new WPI_TalonFX(ELEVATOR_1_ID);
  public static WPI_TalonSRX Intake_3 = new WPI_TalonSRX(ELEVATOR_2_ID);
  public Elevator() {
    Intake_2.setNeutralMode(NeutralMode.Brake);
    Intake_3.setNeutralMode(NeutralMode.Brake);

  }
  public void elevate(double speed) {
    Intake_2.set(-speed);
    Intake_3.set(speed);
    SmartDashboard.putNumber("Intake Speed", speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
