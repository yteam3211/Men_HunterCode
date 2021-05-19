package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.CartridgeCommand;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.DriveTrain;

public class RobotButtons {

    public static final Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_USB);
    
    private final CartridgeSystem cartridgeSystem = new CartridgeSystem();

    private Trigger cartridge = new Trigger(()-> driveJoystick.getPOV() == 0 || driveJoystick.getPOV() == 180);

    public void initButtons(){

        cartridge.whenActive(new CartridgeCommand(cartridgeSystem, driveJoystick));
    }
}
