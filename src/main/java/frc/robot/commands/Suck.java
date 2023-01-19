// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sucker;
import static frc.robot.Constants.Joystick_Axis.*;
import static frc.robot.Constants.Joystick_Button.*;
public class Suck extends CommandBase {
  
  /** Creates a new Suck. */
  private Sucker m_suck;
  private double intakeV;
  private Joystick stick;
  
  public Suck(Sucker suck, double speed, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_suck = suck;
    intakeV = speed;
    stick = joystick;
    addRequirements(m_suck);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }
  // Called every time the scheduler runs while the command is scheduled.

  @Override
  public void execute() {
   //  m_suck.suck(intakeV);
   if(stick.getRawAxis(Left_Trigger) > 0.8) {
    m_suck.suck(0.5);
  }
  else if(stick.getRawButton(Left_Bumper)) {
    m_suck.suck(-0.9);
  }
  else if(stick.getRawButton(X_BUTTON))  {
    m_suck.suck(0.5);
  }
  else {
    m_suck.suck(0);
  }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_suck.suck(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
