// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CartridgeSystem;

public class CartridgeCommand extends CommandBase {
  /** Creates a new CartridgeCommand. */
  Joystick joystick;
  CartridgeSystem cartridgeSystem;
  public CartridgeCommand(CartridgeSystem cartridgeSystem, Joystick joystick) {
    this.joystick = joystick;
    this.cartridgeSystem = cartridgeSystem;

    addRequirements(cartridgeSystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if(joystick.getPOV() == 0) cartridgeSystem.setOutputIn();
    else if(joystick.getPOV() == 180) cartridgeSystem.setOutputIn();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
