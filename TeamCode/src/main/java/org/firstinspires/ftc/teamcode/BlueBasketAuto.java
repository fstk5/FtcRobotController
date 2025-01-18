// package org.firstinspires.ftc.teamcode;
// 
// import android.widget.Switch;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// import java.lang.Math;
// 
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// 
// @Autonomous(name = "BasketAuto", group="Autonomous")
// 
// public class BlueBasketAuto extends LinearOpMode {
// 	private DcMotor VipSliMotor0;
// 	private DcMotor frontleftmotor2;
// 	private DcMotor frontrightmotor3;
// 	private DcMotor leftmotor0;
// 	private DcMotor rightmotor1;
// 	private Servo VSlideServo0;
// 	private Servo ClawServo1;
// 	
// 	@Override
// 	public void runOpMode() {
// 		leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
// 		rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
// 		frontleftmotor2 = hardwareMap.get(DcMotor.class, "frontleftmotor2");
// 		frontrightmotor3 = hardwareMap.get(DcMotor.class, "frontrightmotor3");
// 		VipSliMotor0 = hardwareMap.get(DcMotor.class, "VipSliMotor0");
// 		VSlideServo0 = hardwareMap.get(Servo.class, "VSlideServo0");
// 		ClawServo1 = hardwareMap.get(Servo.class, "ClawServo1");
// 		
// 		leftmotor0.setDirection(DcMotor.Direction.REVERSE);
// 		rightmotor1.setDirection(DcMotor.Direction.FORWARD);
// 		frontleftmotor2.setDirection(DcMotor.Direction.REVERSE);
// 		frontrightmotor3.setDirection(DcMotor.Direction.FORWARD);
// 		VipSliMotor0.setDirection(DcMotor.Direction.REVERSE);
// 		waitForStart();
// 		
// 		if (opModeIsActive()) {
// 			/*Put Autonomous Code Here (Use the given functions below)
// 			 * basically
// 			 * yourFunctionHere(speed out of -1 to 1, time in milliseconds)
// 			 * also leave the terminateOpModeNow() function in place
// 			 * makes sure that the thing ends peacefully
// 			 *
// 			 * check the autonomous.md file for function meanings and how to use them
// 			 */
// 			
// 			EncoderBasedDriving encoderBasedDriving = new EncoderBasedDriving();
// 			
// 			encoderBasedDriving.clawud(0);
// 			sleep(100);
// 			encoderBasedDriving.slide(1, -2);
// 			sleep(250);
// 			encoderBasedDriving.turn(1,-0.75);
// 			sleep(250);
// 			encoderBasedDriving.slide(1, -1.35);
// 			sleep(250);
// 			encoderBasedDriving.drive(0.35,-1.5);
// 			sleep(250);
// 			encoderBasedDriving.vipSli(0.25,0.05);
// 			sleep(250);
// 			
// 			terminateOpModeNow();
// 		}
// 	}
// 	
// 	public class SwitchMode {
// 		
// 		private void initRunWithEncoders() {
// 			leftmotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			leftmotor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
// 			rightmotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			rightmotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
// 			frontleftmotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			frontleftmotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
// 			frontrightmotor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			frontrightmotor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
// 			VipSliMotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			VipSliMotor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
// 		}
// 		
// 		private void initRunToPosition() {
// 			leftmotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			leftmotor0.setTargetPosition(0);
// 			leftmotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
// 			rightmotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			rightmotor1.setTargetPosition(0);
// 			rightmotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
// 			frontleftmotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			frontleftmotor2.setTargetPosition(0);
// 			frontleftmotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
// 			frontrightmotor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			frontrightmotor3.setTargetPosition(0);
// 			frontrightmotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
// 			VipSliMotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 			VipSliMotor0.setTargetPosition(0);
// 			VipSliMotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
// 		}
// 		
// 		private void initTimeBased() {
// 			leftmotor0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// 			rightmotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// 			frontleftmotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// 			frontrightmotor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// 			VipSliMotor0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// 		}
// 	}
// 	
// 	public class EncoderBasedDriving {
// 		
// 		SwitchMode switchMode = new SwitchMode();
// 		
// 		private void drive(double speed, double rotations) {
// 			switchMode.initRunToPosition();
// 			int Rotations = Math.toIntExact(Math.round(rotations * 385));
// 			leftmotor0.setTargetPosition(Rotations);
// 			rightmotor1.setTargetPosition(Rotations);
// 			frontleftmotor2.setTargetPosition(Rotations);
// 			frontrightmotor3.setTargetPosition(Rotations);
// 			do {
// 				leftmotor0.setPower(speed);
// 				rightmotor1.setPower(speed);
// 				frontleftmotor2.setPower(speed);
// 				frontrightmotor3.setPower(speed);
// 			} while (leftmotor0.isBusy() && rightmotor1.isBusy() && frontleftmotor2.isBusy() && frontrightmotor3.isBusy());
// 		}
// 		
// 		private void slide(double speed, double rotations) {
// 			switchMode.initRunToPosition();
// 			int Rotations = Math.toIntExact(Math.round(rotations * 385));
// 			leftmotor0.setTargetPosition(-Rotations);
// 			rightmotor1.setTargetPosition(Rotations);
// 			frontleftmotor2.setTargetPosition(Rotations);
// 			frontrightmotor3.setTargetPosition(-Rotations);
// 			do {
// 				leftmotor0.setPower(speed);
// 				rightmotor1.setPower(speed);
// 				frontleftmotor2.setPower(speed);
// 				frontrightmotor3.setPower(speed);
// 			} while (leftmotor0.isBusy() && rightmotor1.isBusy() && frontleftmotor2.isBusy() && frontrightmotor3.isBusy());
// 		}
// 		
// 		private void turn(double speed, double rotations) {
// 			switchMode.initRunToPosition();
// 			int Rotations = Math.toIntExact(Math.round(rotations * 385));
// 			leftmotor0.setTargetPosition(Rotations);
// 			rightmotor1.setTargetPosition(-Rotations);
// 			frontleftmotor2.setTargetPosition(Rotations);
// 			frontrightmotor3.setTargetPosition(-Rotations);
// 			do {
// 				leftmotor0.setPower(speed);
// 				rightmotor1.setPower(speed);
// 				frontleftmotor2.setPower(speed);
// 				frontrightmotor3.setPower(speed);
// 			} while (leftmotor0.isBusy() && rightmotor1.isBusy() && frontleftmotor2.isBusy() && frontrightmotor3.isBusy());
// 		}
// 		
// 		private void vipSli(double speed, double rotations) {
// 			switchMode.initRunToPosition();
// 			int Rotations = Math.toIntExact(Math.round(rotations * 752));
// 			VipSliMotor0.setTargetPosition(Rotations);
// 			do {
// 				VipSliMotor0.setPower(speed);
// 			} while (VipSliMotor0.isBusy());
// 		}
// 		
// 		private void clawud(int position) {
// 			VSlideServo0.setPosition(position);
// 		}
// 		
// 		private void clawoc(int position) {
// 			ClawServo1.setPosition(position);
// 		}
// 	}
// 	
// 	private class timeBasedDriving {
// 		
// 		SwitchMode switchMode = new SwitchMode();
// 		
// 		private void drive(double speed, long time) {
// 			switchMode.initTimeBased();
// 			leftmotor0.setPower(speed);
// 			rightmotor1.setPower(speed);
// 			frontleftmotor2.setPower(speed);
// 			frontrightmotor3.setPower(speed);
// 			sleep(time);
// 		}
// 		
// 		private void slide(double speed, long time) {
// 			leftmotor0.setPower(-speed);
// 			rightmotor1.setPower(speed);
// 			frontleftmotor2.setPower(speed);
// 			frontrightmotor3.setPower(-speed);
// 			sleep(time);
// 		}
// 		
// 		private void turn(double speed, long time) {
// 			leftmotor0.setPower(speed);
// 			rightmotor1.setPower(-speed);
// 			frontleftmotor2.setPower(speed);
// 			frontrightmotor3.setPower(-speed);
// 			sleep(time);
// 		}
// 		
// 		private void vipSli(double speed, long time) {
// 			
// 			VipSliMotor0.setPower(speed);
// 			sleep(time);
// 		}
// 		
// 		private void clawoc(long position, long time) {
// 			ClawServo1.setPosition(position);
// 			sleep(time);
// 		}
// 		
// 		private void clawud(long position, long time) {
// 			VSlideServo0.setPosition(position);
// 			sleep(time);
// 		}
// 	}
// }