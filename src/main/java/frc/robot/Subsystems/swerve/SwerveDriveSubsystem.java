package frc.robot.Subsystems.swerve;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.utility.PhoenixPIDController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.DriveController;

public class SwerveDriveSubsystem extends SubsystemBase{

    CommandSwerveDrivetrain drivetrain;


    public SwerveDriveSubsystem(SwerveDrivetrainConstants driveTrainConstants, SwerveModuleConstants... modules){
        drivetrain = new CommandSwerveDrivetrain(driveTrainConstants, modules);
    }

    public void periodic(){
        drivetrain.update();
    }

    public Command fieldCentricDrive(){
        return run( () ->
                drivetrain.setControl(
                        new SwerveRequest.FieldCentric()
                                .withVelocityX(DriveController.StrafeAxis.getAsDouble())
                                .withVelocityY(DriveController.ForwardAxis.getAsDouble())
                                .withRotationalRate(DriveController.RotationAxis.getAsDouble())
                )
        );
    }

    public Command speakerTargetedDrive(){
        return run( () ->
                drivetrain.setControl(
                        new SwerveRequest.FieldCentricFacingAngle()
                                .withVelocityX(DriveController.StrafeAxis.getAsDouble())
                                .withVelocityY(DriveController.ForwardAxis.getAsDouble())
                                //.withTargetDirection()
                )


        );
    }


}
