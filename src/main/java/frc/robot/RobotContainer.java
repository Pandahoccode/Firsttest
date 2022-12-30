// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

//import subsystems
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Sucker;

//import command
import frc.robot.commands.Suck;
import frc.robot.commands.Auto;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.Elevate;

//import constants
import static frc.robot.Constants.Speed.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static frc.robot.Constants.Joystick_Button.*;

/**%
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

 public class RobotContainer {

  // The robot's subsystems are defined here...
  public Joystick psman = new Joystick(0);
  public final Sucker m_suck = new Sucker();
  public final Drivebase drivebase = new Drivebase();
  public final Elevator m_elevator = new Elevator();

  // The robot's commands are defined here...
  Command Suck = new Suck(m_suck, V_INTAKE);
  Command Spit = new Suck(m_suck, -V_INTAKE);
  Command Elevator_Up = new Elevate(m_elevator, V_LOW);
  Command Elevator_Down = new Elevate(m_elevator, - V_LOW);
  Command Auto = new Auto(drivebase, m_suck, m_elevator);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(psman, A_BUTTON).whileActiveOnce(Suck);
    new JoystickButton(psman, B_BUTTON).whileActiveOnce(Spit);
    new JoystickButton(psman, X_BUTTON).whileActiveOnce(Elevator_Up);
    new JoystickButton(psman, Y_BUTTON).whileActiveOnce(Elevator_Down);
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    
    return Auto;
  }
}
