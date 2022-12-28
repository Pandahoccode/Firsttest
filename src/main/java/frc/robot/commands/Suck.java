// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sucker;

public class Suck extends CommandBase {
  
  /** Creates a new Suck. */
  private Sucker m_intake;
  private double intakeV;
  public Suck(Sucker intake, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intake = intake;
    intakeV = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.intake(intakeV);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.intake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
