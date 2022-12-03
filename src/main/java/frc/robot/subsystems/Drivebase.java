// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import subsystem in Constants 
import static  frc.robot.Constants.Subsystem.*;
import static frc.robot.Constants.Joystick_Button.*;
import static frc.robot.Constants.Joystick_Axis.*;

public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX (RM_MOTOR_ID);
  public WPI_TalonSRX leftMaster  = new WPI_TalonSRX (RF_MOTOR_ID);
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX (LM_MOTOR_ID);
  public WPI_TalonSRX leftFollow  = new WPI_TalonSRX (LF_MOTOR_ID);
  
  public Joystick psman = new Joystick(1);
  public Drivebase() {


    //Follow
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
    
    //set Inverted
    leftFollow.setInverted(true);
    leftMaster.setInverted(true);
    
    //Set Neutral Mode
    rightMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    leftFollow.setNeutralMode(NeutralMode.Brake);
    //
  }
  public void drive (double leftDrive, double rightDrive) {
    leftMaster.set(leftDrive);
    rightMaster.set(rightDrive);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double speed_boost = psman.getRawButton(A_BUTTON)? 0.8: 0.4;
    drive(psman.getRawAxis(1)*speed_boost, psman.getRawAxis(3)*speed_boost);
    drive(psman.getRawAxis(2)*speed_boost, psman.getRawAxis(4)*speed_boost);
  } 
}
