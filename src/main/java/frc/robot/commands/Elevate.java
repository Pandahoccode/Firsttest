// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Sucker;

public class Elevate extends CommandBase {
  /** Creates a new Elevate. */
  private Elevator m_elevate;
  private Sucker m_suck;
  private double elevateV1;
  private double speed_suck;
  private double elevateV2; 

  public Elevate (Sucker suck, Elevator elevate,  double suckV, double elevate_1, double elevate_2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevate = elevate;
    m_suck = suck;
    elevateV1 = elevate_1;
    speed_suck = suckV;
    elevateV2 = elevate_2;
    
    addRequirements(m_elevate);
    addRequirements(m_suck);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_elevate.elevate(speed_suck, elevateV1, elevateV2);
    SmartDashboard.putNumber("Speed Suck: ", speed_suck);
    SmartDashboard.putNumber("elevateV1: ", elevateV1);
    SmartDashboard.putNumber("elevateV2: ", elevateV2);
    
    SmartDashboard.getNumber("Speed Suck: ", speed_suck);
    SmartDashboard.getNumber("elevateV1: ", elevateV1);
    SmartDashboard.getNumber("elevateV2: ", elevateV2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevate.elevate(0,0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

