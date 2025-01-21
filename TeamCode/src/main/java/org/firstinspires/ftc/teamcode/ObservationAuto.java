package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "ObsZoneAuto", group = "Autonomous")

public class ObservationAuto extends LinearOpMode {
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
		
		br0.setDirection(DcMotor.Direction.FORWARD);
		bl1.setDirection(DcMotor.Direction.REVERSE);
		fl2.setDirection(DcMotor.Direction.REVERSE);
		fr3.setDirection(DcMotor.Direction.FORWARD);
		ctHubViper0.setDirection(DcMotor.Direction.FORWARD);
		expHubViper1.setDirection(DcMotor.Direction.REVERSE);
		linAct2.setDirection(DcMotor.Direction.FORWARD);
		waitForStart();
		
		if (opModeIsActive()) {
			/*Put Autonomous Code Here (Use the given functions below)
			 * basically
			 * yourFunctionHere(speed out of -1 to 1, time in milliseconds)
			 * also leave the terminateOpModeNow() function in place
			 * makes sure that the thing ends peacefully
			 *
			 * check the autonomous.md file for function meanings and how to use them
			 */
			SwitchMode switchMode = new SwitchMode();
			EncoderBasedDriving encoderBasedDriving = new EncoderBasedDriving();
			
			encoderBasedDriving.drive(0.5, -385);
			sleep(250);
			
			
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
			ctHubViper0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			ctHubViper0.setTargetPosition(0);
			ctHubViper0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			expHubViper1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			expHubViper1.setTargetPosition(0);
			expHubViper1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			linAct2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			linAct2.setTargetPosition(0);
			linAct2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
			hangClaw3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			hangClaw3.setTargetPosition(0);
			hangClaw3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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
	
	public class EncoderBasedDriving {
		
		SwitchMode switchMode = new SwitchMode();
		
		private void drive(double speed, int ticks) {
			switchMode.initRunToPosition();
			br0.setTargetPosition(ticks);
			bl1.setTargetPosition(ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(ticks);
			do {
				br0.setPower(speed);
				bl1.setPower(speed);
				fl2.setPower(speed);
				fr3.setPower(speed);
			} while (br0.isBusy() && bl1.isBusy() && fl2.isBusy() && fr3.isBusy());
		}
		
		private void slide(double speed, int ticks) {
			switchMode.initRunToPosition();
			br0.setTargetPosition(-ticks);
			bl1.setTargetPosition(ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(-ticks);
			do {
				br0.setPower(speed);
				bl1.setPower(speed);
				fl2.setPower(speed);
				fr3.setPower(speed);
			} while (br0.isBusy() && bl1.isBusy() && fl2.isBusy() && fr3.isBusy());
		}
		
		private void turn(double speed, int ticks) {
			switchMode.initRunToPosition();
			br0.setTargetPosition(ticks);
			bl1.setTargetPosition(-ticks);
			fl2.setTargetPosition(ticks);
			fr3.setTargetPosition(-ticks);
			do {
				br0.setPower(speed);
				bl1.setPower(speed);
				fl2.setPower(speed);
				fr3.setPower(speed);
			} while (br0.isBusy() && bl1.isBusy() && fl2.isBusy() && fr3.isBusy());
		}
		
		private void vipers(double speed, int ticks) {
			switchMode.initRunToPosition();
			ctHubViper0.setTargetPosition(ticks);
			expHubViper1.setTargetPosition(ticks);
			do {
				ctHubViper0.setPower(speed);
				expHubViper1.setPower(speed);
			} while (ctHubViper0.isBusy() && expHubViper1.isBusy());
		}
		
		private void linAct(double speed, int ticks) {
			switchMode.initRunToPosition();
			linAct2.setTargetPosition(ticks);
			do {
				linAct2.setPower(speed);
			} while (linAct2.isBusy());
		}
		
		private void clawoc(int position) {
			ccs0.setPosition(position);
		}
		
		private void clawud(int position) {
			wls1.setPosition(position);
		}
		
		private void clawr(int position) {
			crs2.setPosition(position);
		}
	}
	
	private class timeBasedDriving {
		
		SwitchMode switchMode = new SwitchMode();
		
		private void drive(double speed, long time) {
			switchMode.initTimeBased();
			br0.setPower(speed);
			bl1.setPower(speed);
			fl2.setPower(speed);
			fr3.setPower(speed);
			sleep(time);
			stop("driveSystem");
		}
		
		private void slide(double speed, long time) {
			switchMode.initTimeBased();
			br0.setPower(-speed);
			bl1.setPower(speed);
			fl2.setPower(speed);
			fr3.setPower(-speed);
			sleep(time);
			stop("driveSystem");
		}
		
		private void turn(double speed, long time) {
			switchMode.initTimeBased();
			br0.setPower(speed);
			bl1.setPower(-speed);
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
			switchMode.initTimeBased();
			wls1.setPosition(position);
			sleep(time);
		}
		
		private void clawud(long position, long time) {
			switchMode.initTimeBased();
			ccs0.setPosition(position);
			sleep(time);
		}
	}
	
	/**
	 * Stops selected functions in variable 'function'
	 * & stops all functions if variable is empty, possible values are:
	 * driveSystem (bl0, br1, fl2, fr3), viperSystem (ctHubViper0, expHubViper1), clawSystem (linAct2)
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
//				linAct2.setPower(0);
				break;
			default:
				bl1.setPower(0);
				br0.setPower(0);
				fl2.setPower(0);
				fr3.setPower(0);
				ctHubViper0.setPower(0);
				expHubViper1.setPower(0);
//				linAct2.setPower(0);
				break;
		}
	}
}