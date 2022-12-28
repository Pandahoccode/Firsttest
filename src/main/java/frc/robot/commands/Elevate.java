// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class Elevate extends CommandBase {
  /** Creates a new Elevate. */
  private Elevator m_elevate;
  private double elevateV;

  public Elevate (Elevator elevate, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevate = elevate;
    speed = elevateV;
    addRequirements(m_elevate);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_elevate.elevate(elevateV);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevate.elevate(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
