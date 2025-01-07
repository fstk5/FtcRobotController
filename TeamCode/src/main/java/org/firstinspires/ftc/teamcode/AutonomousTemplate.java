package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Disabled//(name = "AutonomousTemplate")

public class AutonomousTemplate extends LinearOpMode {
	private DcMotor VipSliMotor0;
	private DcMotor frontleftmotor2;
	private DcMotor frontrightmotor3;
	private DcMotor leftmotor0;
	private DcMotor rightmotor1;
	private Servo VSlideServo1;
	private Servo ClawServo0;

	@Override
	public void runOpMode() {
		leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
		rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
		frontleftmotor2 = hardwareMap.get(DcMotor.class, "frontleftmotor2");
		frontrightmotor3 = hardwareMap.get(DcMotor.class, "frontrightmotor3");
		VipSliMotor0 = hardwareMap.get(DcMotor.class, "VipSliMotor0");
		VSlideServo1 = hardwareMap.get(Servo.class, "VSlideServo1");
		ClawServo0 = hardwareMap.get(Servo.class, "ClawServo0");

		leftmotor0.setDirection(DcMotor.Direction.REVERSE);
		rightmotor1.setDirection(DcMotor.Direction.FORWARD);
		frontleftmotor2.setDirection(DcMotor.Direction.REVERSE);
		frontrightmotor3.setDirection(DcMotor.Direction.FORWARD);
		VipSliMotor0.setDirection(DcMotor.Direction.REVERSE);
		waitForStart();

		if (opModeIsActive()) {
			/*Put Autonomous Code Here (Use the given functions below)
			* basidcally
			* yourFunctionHere(speed out of -1-1, time in milliseconds)
			* also leave the terminateOpModeNow() function in place
			* makes sure that the thing ends peacefully
			*/

			terminateOpModeNow();
		}
	}
	private void drive(double speed, long time) {
		leftmotor0.setPower(speed);
		rightmotor1.setPower(speed);
		frontleftmotor2.setPower(speed);
		frontrightmotor3.setPower(speed);
		sleep(time);
	}

	private void slide(double speed, long time) {
		leftmotor0.setPower(-speed);
		rightmotor1.setPower(speed);
		frontleftmotor2.setPower(speed);
		frontrightmotor3.setPower(-speed);
		sleep(time);
	}

	private void turn(double speed, long time) {
		leftmotor0.setPower(speed);
		rightmotor1.setPower(-speed);
		frontleftmotor2.setPower(speed);
		frontrightmotor3.setPower(-speed);
		sleep(time);
	}

	private void vipSli(double speed, long time) {
		VipSliMotor0.setPower(speed);
		sleep(time);
	}
	
	private void clawoc(long position, long time) {
		ClawServo0.setPosition(position);
		sleep(time);
	}
	
	private void clawud(long position, long time) {
		VSlideServo1.setPosition(position);
		sleep(time);
	}
}