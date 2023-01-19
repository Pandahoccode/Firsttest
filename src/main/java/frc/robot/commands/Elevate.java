// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

import static frc.robot.Constants.Joystick_Axis.*;
import static frc.robot.Constants.Joystick_Button.*;

public class Elevate extends CommandBase {
  public Joystick psman = new Joystick(0);
  /** Creates a new Elevate. */
  private Elevator m_elevate;
  private double elevateV1;
  private double elevateV2; 

  public Elevate (Elevator elevate, double elevate_1, double elevate_2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevate = elevate;
    elevateV1 = elevate_1;
    elevateV2 = elevate_2;
    
    addRequirements(m_elevate);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    // m_elevate.elevate(elevateV1, elevateV2);
    SmartDashboard.putNumber("elevateV1: ", elevateV1);
    SmartDashboard.putNumber("elevateV2: ", elevateV2);
    

    SmartDashboard.getNumber("elevateV1: ", elevateV1);
    SmartDashboard.getNumber("elevateV2: ", elevateV2);

    if(psman.getRawAxis(Left_Trigger)>0.8) {
      m_elevate.elevate(-0.4, 0.6);
    }
    else if(psman.getRawButton(Right_Bumper)) {
      m_elevate.elevate(0.6, -0.9);
    }
    else { 
      m_elevate.elevate(0, 0);
    } 

   }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevate.elevate(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

