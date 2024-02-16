package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.oi.OI;
import frc.robot.subsystems.shooterPivot.IShooterPivotSubsystem;

public class ManualShooterPivotCommand extends Command{
    private final IShooterPivotSubsystem shooterPivotSubsystem;
    private final OI oi;

    public ManualShooterPivotCommand(IShooterPivotSubsystem iShooterPivotSubsystem, OI oi){
        this.shooterPivotSubsystem = iShooterPivotSubsystem;
        this.oi = oi;

        addRequirements(iShooterPivotSubsystem);
    }

    @Override
    public void initialize(){
        shooterPivotSubsystem.stop();
    }

    @Override
    public void execute(){
        shooterPivotSubsystem.manualSet(oi.operatorController().getAxis(
                Constants.Controls.OperatorControls.ShooterPivotAxis
        ));
    }

    @Override
    public void end(boolean interrupted){
        shooterPivotSubsystem.stop();
    }

}
