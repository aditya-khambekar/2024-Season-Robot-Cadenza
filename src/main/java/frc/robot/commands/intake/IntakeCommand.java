package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.RobotInfo.HopperInfo;
import frc.robot.subsystems.hopper.IHopperSubsystem;
import frc.robot.subsystems.intake.IIntakeSubsystem;

public class IntakeCommand extends Command {
    private final IIntakeSubsystem intake;
    private final IHopperSubsystem hopper;
    private double noteTime;
    private boolean seen = false;

    public IntakeCommand(IIntakeSubsystem intake, IHopperSubsystem hopper) {
        this.intake = intake;
        this.hopper = hopper;

        addRequirements(intake, hopper);
        
    }

    @Override
    public void execute() {
        intake.setExtended(IIntakeSubsystem.ExtensionState.EXTENDED);
        intake.intake();
        hopper.run(false, HopperInfo.HOPPER_SPEED);
        if (!seen){
            if (hopper.getIR().hasNote()){
                noteTime = Timer.getFPGATimestamp();
                seen = true;
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        intake.stopIntake();
        hopper.stop();

        if(!interrupted) {
            intake.setExtended(IIntakeSubsystem.ExtensionState.RETRACTED);
        }

        seen = false;
    }

    @Override
    public boolean isFinished(){
        return seen == true && Timer.getFPGATimestamp() - noteTime > 0.;
    }
}
