// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Trapper;

public class Trapdoor extends CommandBase {
  
  /** Creates a new TrapDoor. */
  private Trapper m_tDoor;
  private double trapV;
  
  public Trapdoor(Trapper tDoor, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_tDoor = tDoor;
    trapV = speed;
    addRequirements(m_tDoor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.

  @Override
  public void execute() {
    m_tDoor.trap(trapV);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tDoor.trap(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

