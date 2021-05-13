
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotButtons;
import frc.robot.subsystems.DriveTrain;

public class JoystickDriveCommand extends CommandBase {

  double leftOutput, rightOutput;

  DriveTrain driveTrain;

  public JoystickDriveCommand(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double xStick = RobotButtons.driveJostick.getRawAxis(Constants.X_AXIS_DRIVE);
    double zStick = RobotButtons.driveJostick.getRawAxis(Constants.Z_AXIS_DRIVE);

    leftOutput = xStick + zStick;
    rightOutput = xStick - zStick;

    driveTrain.tank(leftOutput, rightOutput);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.tank(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
