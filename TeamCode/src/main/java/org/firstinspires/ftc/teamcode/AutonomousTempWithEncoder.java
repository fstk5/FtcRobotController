package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled//(name = "Autonomous Template w/ Encoders")

public class AutonomousTempWithEncoder extends LinearOpMode {
	private DcMotor ctHubViper0;
	private DcMotor expHubViper1;
	private DcMotor clawViper2;
	private DcMotor hangClaw3;
	private DcMotor fl2;
	private DcMotor fr3;
	private DcMotor bl1;
	private DcMotor br0;
	private Servo ccs0;
	private Servo cws1;
	
	@Override
	public void runOpMode() {
		bl1 = hardwareMap.get(DcMotor.class, "bl1");
		br0 = hardwareMap.get(DcMotor.class, "br0");
		fl2 = hardwareMap.get(DcMotor.class, "fl2");
		fr3 = hardwareMap.get(DcMotor.class, "fr3");
		hangClaw3 = hardwareMap.get(DcMotor.class, "hangClaw3");
		ctHubViper0 = hardwareMap.get(DcMotor.class, "ctHubViper0");
		expHubViper1 = hardwareMap.get(DcMotor.class, "expHubViper1");
		clawViper2 = hardwareMap.get(DcMotor.class, "clawViper2");
		ccs0 = hardwareMap.get(Servo.class, "ccs0");
		cws1 = hardwareMap.get(Servo.class, "cws1");
		
		bl1.setDirection(DcMotor.Direction.REVERSE);
		br0.setDirection(DcMotor.Direction.FORWARD);
		fl2.setDirection(DcMotor.Direction.REVERSE);
		fr3.setDirection(DcMotor.Direction.FORWARD);
		ctHubViper0.setDirection(DcMotor.Direction.FORWARD);
		expHubViper1.setDirection(DcMotor.Direction.REVERSE);
		clawViper2.setDirection(DcMotor.Direction.FORWARD);
		hangClaw3.setDirection(DcMotor.Direction.FORWARD);
		waitForStart();
		
		if (opModeIsActive()) {
			/*Put Autonomous Code Here (Use the given functions below)
			 * basidcally
			 * yourFunctionHere(speed out of -1-1, time in milliseconds)
			 * also leave the terminateOpModeNow() function in place
			 * makes sure that the thing ends peacefully
			 *
			 * check the autonomous.md file for function meanings and how to use them
			 */
			SwitchMode switchMode = new SwitchMode();
			terminateOpModeNow();
		}
	}
	
	public class SwitchMode {
		
		private void initRunWithEncoders() {
			bl1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			bl1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			br0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			br0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			fl2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fl2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			fr3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fr3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			clawViper2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			clawViper2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		}
		
		private void initRunToPosition() {
			bl1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			bl1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			br0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			br0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			fl2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fl2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			fr3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fr3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			ctHubViper0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			expHubViper1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			clawViper2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			clawViper2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
		}
		
		private void initTimeBased() {
			bl1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			br0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			fl2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			fr3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			clawViper2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		}
	}
	
	public class encoderBasedDriving {
		
		SwitchMode switchMode = new SwitchMode();
		
		private void drive(double speed, int ticks) {
			switchMode.initRunToPosition();
			bl1.setTargetPosition(ticks);
			br0.setTargetPosition(ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(ticks);
			bl1.setPower(speed);
			br0.setPower(speed);
			fl2.setPower(speed);
			fr3.setPower(speed);
			while (bl1.isBusy() && br0.isBusy() && fl2.isBusy() && fr3.isBusy()) {
				sleep(250);
			}
		}
		
		private void slide(double speed, int ticks) {
			switchMode.initRunToPosition();
			bl1.setTargetPosition(-ticks);
			bl1.setPower(speed);
			br0.setTargetPosition(ticks);
			br0.setPower(speed);
			fl2.setTargetPosition(ticks);
			fl2.setPower(speed);
			fr3.setTargetPosition(-ticks);
			fr3.setPower(speed);
			while (bl1.isBusy() && br0.isBusy() && fl2.isBusy() && fr3.isBusy()) {
				sleep(250);
			}
		}
		
		private void turn(double speed, int ticks) {
			switchMode.initRunToPosition();
			bl1.setTargetPosition(ticks);
			br0.setTargetPosition(-ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(-ticks);
			bl1.setPower(speed);
			br0.setPower(speed);
			fl2.setPower(speed);
			fr3.setPower(speed);
			while (bl1.isBusy() && br0.isBusy() && fl2.isBusy() && fr3.isBusy()) {
				sleep(250);
			}
		}
		
		private void dualVSlide(double speed, int ticks) {
			switchMode.initRunToPosition();
			ctHubViper0.setTargetPosition(ticks);
			expHubViper1.setTargetPosition(ticks);
			ctHubViper0.setPower(speed);
			expHubViper1.setPower(speed);
			while (ctHubViper0.isBusy() && expHubViper1.isBusy()) {
				sleep(250);
			}
		}
		
		private void clawud(long position) {
			cws1.setPosition(position);
		}
		
		private void clawoc(long position) {
			ccs0.setPosition(position);
		}
		
		private void hang() {
			if (gamepad1.b) {
				hangClaw3.setPower(1);
			}
			else if (gamepad1.a) {
				hangClaw3.setPower(-1);
			}
			else {
				hangClaw3.setPower(0);
			}
		}
	}
	
	private class timeBasedDriving {
		
		SwitchMode switchMode = new SwitchMode();
		
		private void drive(double speed, long time) {
			switchMode.initTimeBased();
			bl1.setPower(speed);
			br0.setPower(speed);
			fl2.setPower(speed);
			fr3.setPower(speed);
			sleep(time);
			stop("driveSystem");
		}
		
		private void slide(double speed, long time) {
			switchMode.initTimeBased();
			bl1.setPower(-speed);
			br0.setPower(speed);
			fl2.setPower(speed);
			fr3.setPower(-speed);
			sleep(time);
			stop("driveSystem");
		}
		
		private void turn(double speed, long time) {
			switchMode.initTimeBased();
			bl1.setPower(speed);
			br0.setPower(-speed);
			fl2.setPower(speed);
			fr3.setPower(-speed);
			sleep(time);
			stop("driveSystem");
		}
		
		private void vipSli(double speed, long time) {
			switchMode.initTimeBased();
			ctHubViper0.setPower(speed);
			expHubViper1.setPower(speed);
			sleep(time);
			stop("viperSystem");
		}
	}
	
	/**
	 * Stops selected functions in variable 'function'
	 * & stops all functions if variable is empty, possible values are:
	 * driveSystem (bl0, br1, fl2, fr3), viperSystem (ctHubViper0, expHubViper1), clawSystem (clawViper2)
	 * */
	private void stop(String functions) {
		switch (functions) {
			case "driveSystem":
				bl1.setPower(0);
				br0.setPower(0);
				fl2.setPower(0);
				fr3.setPower(0);
				break;
			case "viperSystem":
				ctHubViper0.setPower(0);
				expHubViper1.setPower(0);
				break;
			case "clawSystem":
				clawViper2.setPower(0);
				break;
			default:
				bl1.setPower(0);
				br0.setPower(0);
				fl2.setPower(0);
				fr3.setPower(0);
				ctHubViper0.setPower(0);
				expHubViper1.setPower(0);
				clawViper2.setPower(0);
				break;
		}
	}
}