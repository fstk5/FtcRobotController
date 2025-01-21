package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "L1AscentAutoV2", group = "Autonomous")

public class L1AscentAutoV2 extends LinearOpMode {
	private DcMotor br0;
	private DcMotor bl1;
	private DcMotor fl2;
	private DcMotor fr3;
	private DcMotor ctHubViper0;
	private DcMotor expHubViper1;
	private DcMotor linAct2;
	private DcMotor hangClaw3;
	private Servo ccs0;
	private Servo wls1;
	private Servo crs2;
	private double speedMod;
	private boolean lucasJAMES;
	
	private boolean banana;
	private volatile boolean holdVSlide;
	
	@Override
	public void runOpMode() {
		br0 = hardwareMap.get(DcMotor.class, "br0");
		bl1 = hardwareMap.get(DcMotor.class, "bl1");
		fl2 = hardwareMap.get(DcMotor.class, "fl2");
		fr3 = hardwareMap.get(DcMotor.class, "fr3");
		ctHubViper0 = hardwareMap.get(DcMotor.class, "ctHubViper0");
		expHubViper1 = hardwareMap.get(DcMotor.class, "expHubViper1");
		linAct2 = hardwareMap.get(DcMotor.class, "linAct2");
		hangClaw3 = hardwareMap.get(DcMotor.class, "hangClaw3");
		ccs0 = hardwareMap.get(Servo.class, "ccs0");
		wls1 = hardwareMap.get(Servo.class, "wls1");
		crs2 = hardwareMap.get(Servo.class, "crs2");
		
		bl1.setDirection(DcMotor.Direction.REVERSE);
		br0.setDirection(DcMotor.Direction.FORWARD);
		fl2.setDirection(DcMotor.Direction.REVERSE);
		fr3.setDirection(DcMotor.Direction.FORWARD);
		ctHubViper0.setDirection(DcMotor.Direction.FORWARD);
		expHubViper1.setDirection(DcMotor.Direction.REVERSE);
		linAct2.setDirection(DcMotor.Direction.FORWARD);
		
		ccs0.setPosition(0.75);//this runs when you press inititallize
		
		ElapsedTime runtime = new ElapsedTime();
		
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
			encoderBasedDriving EncoderBasedDriving = new encoderBasedDriving();
			
			
			ctHubViper0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			ctHubViper0.setTargetPosition(0);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			expHubViper1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			expHubViper1.setTargetPosition(0);
			expHubViper1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			
			
		/*	sleep(250);
			EncoderBasedDriving.slide(0.75, 250);
			sleep(250);
			EncoderBasedDriving.drive(0.5, 500);
			sleep(250);
			EncoderBasedDriving.turn(0.5, -250);
			sleep(250);
			EncoderBasedDriving.slide(0.5, 175);
			sleep(250); */
			EncoderBasedDriving.vipers(0.75, 1100);//2100 for second number
			sleep(1750);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			ctHubViper0.setPower(0.3);
			expHubViper1.setPower(0.3);
			sleep(1000);
			EncoderBasedDriving.drive(0.2, 400);
			sleep(1000);
			EncoderBasedDriving.clawoc(1);
			sleep(1000);
			EncoderBasedDriving.drive(0.2, -400);
			sleep(500);
			ctHubViper0.setPower(0.001);
			expHubViper1.setPower(0.001);
			sleep(8000);
			ctHubViper0.setPower(-0.2);
			expHubViper1.setPower(-0.2);
			sleep(600);
			
			
			/*
			viperHold();
			EncoderBasedDriving.drive(0.5, 250);
			runtime.reset();
			do {} while (opModeIsActive() && (runtime.seconds() < 0.25));
			EncoderBasedDriving.clawoc(1);
			runtime.reset();
			do {} while (opModeIsActive() && (runtime.seconds() < 1));
			EncoderBasedDriving.drive(0.5, -800);
			viperHold();
			sleep(250);
			EncoderBasedDriving.turn(0.5, 270);
			sleep(250);
			EncoderBasedDriving.slide(0.75, 900);
			sleep(250);
			EncoderBasedDriving.drive(0.5, -100);
			sleep(250);
			viperHold();
			*/
			terminateOpModeNow();
		}
	}
	
	public class SwitchMode {
		
		private void initRunWithEncoders() {
			br0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			br0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			bl1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			bl1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			fl2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fl2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			fr3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fr3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			linAct2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			linAct2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			hangClaw3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			hangClaw3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		}
		
		private void initRunToPosition() {
			br0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			br0.setTargetPosition(0);
			br0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			bl1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			bl1.setTargetPosition(0);
			bl1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			fl2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fl2.setTargetPosition(0);
			fl2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			fr3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			fr3.setTargetPosition(0);
			fr3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			// ctHubViper0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			// ctHubViper0.setTargetPosition(0);
			// ctHubViper0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			// expHubViper1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			// expHubViper1.setTargetPosition(0);
			// expHubViper1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			linAct2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			linAct2.setTargetPosition(0);
			linAct2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			hangClaw3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			hangClaw3.setTargetPosition(0);
			hangClaw3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
		}
		
		private void initTimeBased() {
			br0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			bl1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			fl2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			fr3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			expHubViper1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			linAct2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			hangClaw3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
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
			do {
				bl1.setPower(speed);
				br0.setPower(speed);
				fl2.setPower(speed);
				fr3.setPower(speed);
			} while (bl1.isBusy() && br0.isBusy() && fl2.isBusy() && fr3.isBusy());
		}
		
		private void slide(double speed, int ticks) {
			switchMode.initRunToPosition();
			bl1.setTargetPosition(-ticks);
			br0.setTargetPosition(ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(-ticks);
			do {
				br0.setPower(speed);
				bl1.setPower(speed);
				fl2.setPower(speed);
				fr3.setPower(speed);
			} while (bl1.isBusy() && br0.isBusy() && fl2.isBusy() && fr3.isBusy());
		}
		
		private void turn(double speed, int ticks) {
			switchMode.initRunToPosition();
			bl1.setTargetPosition(ticks);
			br0.setTargetPosition(-ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(-ticks);
			do {
				bl1.setPower(speed);
				br0.setPower(speed);
				fl2.setPower(speed);
				fr3.setPower(speed);
			} while (bl1.isBusy() && br0.isBusy() && fl2.isBusy() && fr3.isBusy());
		}
		
		private void vipers(double speed, int ticks) {
			switchMode.initRunToPosition();
			expHubViper1.setTargetPosition(ticks);
			expHubViper1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
			// ctHubViper0.setTargetPosition(ticks);
			speedMod = speed * 1.2;
			telemetry.addLine("" + ctHubViper0.getCurrentPosition());
			expHubViper1.setTargetPosition(expHubViper1.getTargetPosition());
			// if (speedMod >= 1) {
			// 	speedMod = 1;
			// }
			do {
				ctHubViper0.setPower(speed);
				expHubViper1.setPower(speed);
			} while (expHubViper1.isBusy());
		}
		
		private void linAct(double speed, int ticks) {
			switchMode.initRunToPosition();
			linAct2.setTargetPosition(ticks);
			do {
				linAct2.setPower(speed);
			} while (linAct2.isBusy());
		}
		
		private void clawud(double position) {
			wls1.setPosition(position);
		}
		
		private void clawoc(double position) {
			ccs0.setPosition(position);
		}
		
		private void clawr(double position) {
			crs2.setPosition(position);
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
		
		private void vipers(double speed, long time) {
			switchMode.initTimeBased();
			ctHubViper0.setPower(speed);
			expHubViper1.setPower(speed);
			sleep(time);
			stop("viperSystem");
		}
		
		private void linAct(double speed, long time) {
			switchMode.initTimeBased();
			linAct2.setPower(speed);
			sleep(time);
			stop("clawSystem");
		}
		
		private void clawoc(long position, long time) {
			wls1.setPosition(position);
			sleep(time);
		}
		
		private void clawud(long position, long time) {
			ccs0.setPosition(position);
			sleep(time);
		}
	}
	
	/**
	 * Stops selected functions in variable 'function'
	 * & stops all functions if variable is empty, possible values are:
	 * driveSystem (bl0, br1, fl2, fr3), viperSystem (ctHubViper0, expHubViper1), clawSystem (linAct2)
	 */
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
				linAct2.setPower(0);
				break;
			default:
				bl1.setPower(0);
				br0.setPower(0);
				fl2.setPower(0);
				fr3.setPower(0);
				ctHubViper0.setPower(0);
				expHubViper1.setPower(0);
				linAct2.setPower(0);
				break;
		}
	}
	
	private void viperHold() {
		holdVSlide = !holdVSlide;
	}
	
	
	private void vslideTelem() {
		do {
			telemetry.update();
		} while (ctHubViper0.isBusy() && expHubViper1.isBusy());
	}

//	private class multithreading extends Thread {
//		@Override
//		public void run() {
//			while (true) {
//				if (holdVSlide) {
//					ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//					ctHubViper0.setPower(0.3);
//					expHubViper1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//					expHubViper1.setPower(0.3);
//				} else if (!holdVSlide) {
//					telemetry.update();
//				}
//			}
//		}
//	}
}