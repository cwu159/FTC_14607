package org.firstinspires.ftc.teamcode.control;

import org.firstinspires.ftc.teamcode.util.MathUtil;

import static org.firstinspires.ftc.teamcode.movement.Odometry.currentPosition;

public class Results {
    public static class baseResult {
        public boolean done;
    }

    public static class movementResult extends baseResult {
        public double turnDelta_rad;
        public movementResult(double targetX, double targetY, double targetAngle, double moveThresh, double angleThresh){
            turnDelta_rad = MathUtil.angleWrap(targetAngle - currentPosition.heading);
            done = Math.hypot(targetX - currentPosition.x, targetY - currentPosition.y) < moveThresh && MathUtil.subtractAngleBool(currentPosition.heading, targetAngle, angleThresh);
        }
    }

    public static class simpleResult extends baseResult {
        public simpleResult(double current, double target, double thresh)  {
            done = Math.abs(current - target) < thresh;
        }
    }
}