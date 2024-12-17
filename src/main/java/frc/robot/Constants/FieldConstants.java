package frc.robot.Constants;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.*;
import edu.wpi.first.math.util.Units;

public class FieldConstants {
    public static final AprilTagFieldLayout kAprilTagLayout = AprilTagFields.k2024Crescendo.loadAprilTagLayoutField();

    public static final double kFieldWidthMeters = kAprilTagLayout.getFieldWidth(); // distance between field walls,
    // 8.211m
    public static final double kFieldLengthMeters = kAprilTagLayout.getFieldLength(); // distance between driver station
    // walls, 16.541m
    
    public static final Pose2d kBlueAmpPose = new Pose2d(1.820, 7.680, Rotation2d.fromDegrees(90.0));
    public static final Pose2d kRedAmpPose = new Pose2d(kFieldWidthMeters - kBlueAmpPose.getX(), kBlueAmpPose.getY(),
            Rotation2d.fromDegrees(180 - kBlueAmpPose.getRotation().getDegrees())); // X 14.7345

    public static final Pose2d kBlueClimbPoseFeed = new Pose2d(4.4, 3.3, Rotation2d.fromDegrees(60.0));
    public static final Pose2d kBlueClimbPoseAmp = new Pose2d(4.43, 4.95, Rotation2d.fromDegrees(-60.0));
    public static final Pose2d kBlueClimbPoseMidline = new Pose2d(5.8, 4.1, Rotation2d.fromDegrees(180.0));
    public static final Pose2d kRedClimbPoseFeed = new Pose2d(kFieldWidthMeters - kBlueClimbPoseFeed.getX(),
            kBlueClimbPoseFeed.getY(), Rotation2d.fromDegrees(180 - kBlueClimbPoseFeed.getRotation().getDegrees()));
    public static final Pose2d kRedClimbPoseAmp = new Pose2d(kFieldWidthMeters - kBlueClimbPoseAmp.getX(),
            kBlueClimbPoseAmp.getY(), Rotation2d.fromDegrees(180 - kBlueClimbPoseAmp.getRotation().getDegrees()));
    public static final Pose2d kRedClimbPoseMidline = new Pose2d(kFieldWidthMeters - kBlueClimbPoseMidline.getX(),
            kBlueClimbPoseMidline.getY(),
            Rotation2d.fromDegrees(180 - kBlueClimbPoseMidline.getRotation().getDegrees()));
    public static final Translation3d kRedSpeakerPose = new Translation3d(
            kAprilTagLayout.getTagPose(4).get().getX(),
            kAprilTagLayout.getTagPose(4).get().getY(), 2.045);
    public static final Translation3d kBlueSpeakerPose = new Translation3d(
            kAprilTagLayout.getTagPose(7).get().getX(),
            kAprilTagLayout.getTagPose(7).get().getY(), 2.045);
    public static final Translation3d kRedSpeakerTopPose = new Translation3d(
            kAprilTagLayout.getTagPose(4).get().getX() - Units.inchesToMeters(20.057),
            kAprilTagLayout.getTagPose(4).get().getY(),
            kAprilTagLayout.getTagPose(4).get().getZ() + Units.inchesToMeters(32.563));
    public static final Translation3d kBlueSpeakerTopPose = new Translation3d(
            kAprilTagLayout.getTagPose(7).get().getX() + Units.inchesToMeters(20.057),
            kAprilTagLayout.getTagPose(7).get().getY(),
            kAprilTagLayout.getTagPose(7).get().getZ() + Units.inchesToMeters(32.563));

    public static final Translation2d kBlueStageCenterPose = new Translation2d(4.83,
            kFieldWidthMeters / 2.0);
    public static final Translation2d kRedStageCenterPose = new Translation2d(
            kFieldLengthMeters - kBlueStageCenterPose.getX(),
            kBlueStageCenterPose.getY());
    public static final double kBlueSpeakerToStageAutoSwitchX = 7.0;
    public static final double kRedSpeakerToStageAutoSwitchX = kFieldLengthMeters - kBlueSpeakerToStageAutoSwitchX;

    public static final double kNoteReleaseHeight = Units.inchesToMeters(22.183);
    public static final Pose3d kLeftRedSpeakerPose = new Pose3d(kAprilTagLayout.getTagPose(4).get().getX(),
            5.875, 2.04, new Rotation3d());
    public static final Pose3d kRightRedSpeakerPose = new Pose3d(kAprilTagLayout.getTagPose(4).get().getX(),
            5.29, 2.04, new Rotation3d());
    public static final Pose3d kLeftBlueSpeakerPose = new Pose3d(kAprilTagLayout.getTagPose(7).get().getX(),
            5.875, 2.04, new Rotation3d());
    public static final Pose3d kRightBlueSpeakerPose = new Pose3d(kAprilTagLayout.getTagPose(7).get().getX(),
            5.29, 2.04, new Rotation3d());
    public static final double kSpeakerLengthMeters = kLeftRedSpeakerPose.getY() - kRightRedSpeakerPose.getY();
}
