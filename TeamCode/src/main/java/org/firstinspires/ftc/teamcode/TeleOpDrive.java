package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleOpDrive")
public class TeleOpDrive extends LinearOpMode {
	
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
	
	private boolean btrue;
	
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
		ccs0.setDirection(Servo.Direction.FORWARD);
		crs2.setDirection(Servo.Direction.FORWARD);
		
		
		br0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		bl1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		fl2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		fr3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		expHubViper1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		
		btrue = false;
		
		waitForStart();
		
		if (opModeIsActive()) {
			while (opModeIsActive()) {
				forward();
				backward();
				turn();
				slide();
				vSlide();
				linAct();
				claw();
				brake();
				hang();
//				flat();
				telemetry.update();
			}
		}
	}
	
	//	private void flat() {
//		ctHubViper0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//		expHubViper1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//		clawViper2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//		hangClaw3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//	}
	private void forward() {
		br0.setPower(gamepad1.right_trigger);
		bl1.setPower(gamepad1.right_trigger);
		fl2.setPower(gamepad1.right_trigger);
		fr3.setPower(gamepad1.right_trigger);
	}
	
	private void hang() {
		if (gamepad1.dpad_up) {
			hangClaw3.setPower(1);
		}
		else if (gamepad1.dpad_down) {
			hangClaw3.setPower(-1);
		}
		else {
			hangClaw3.setPower(0);
		}
	}
	
	private void backward() {
		br0.setPower(-gamepad1.left_trigger);
		bl1.setPower(-gamepad1.left_trigger);
		fl2.setPower(-gamepad1.left_trigger);
		fr3.setPower(-gamepad1.left_trigger);
	}
	
	private void turn() {
		br0.setPower(-gamepad1.left_stick_x);
		bl1.setPower(gamepad1.left_stick_x);
		fl2.setPower(gamepad1.left_stick_x);
		fr3.setPower(-gamepad1.left_stick_x);
	}
	
	private void slide() {
		br0.setPower(gamepad1.right_stick_x);
		bl1.setPower(-gamepad1.right_stick_x);
		fl2.setPower(gamepad1.right_stick_x * 0.9);
		fr3.setPower(-gamepad1.right_stick_x * 0.9);
	}
	
	private void vSlide() {
		if (gamepad2.right_trigger > 0) {
			ctHubViper0.setPower(0.75);
			expHubViper1.setPower(0.75);
		}
		
		else if (gamepad2.left_trigger > 0) {
			ctHubViper0.setPower(-0.5);
			expHubViper1.setPower(-0.5);
		}
		
		else {
			ctHubViper0.setPower(0);
			expHubViper1.setPower(0);
		}
	}
	
	private void linAct() {
		if (gamepad2.right_stick_y > 0) {
			linAct2.setPower(-1);
		} else if (gamepad2.right_stick_y < 0) {
			linAct2.setPower(1);
		}
		else {
			linAct2.setPower(0);
		}
	}
	
	private void claw() {
		//wrist
		if (gamepad2.x) {
			wls1.setPosition(0.3);
		}
		
		else if (gamepad2.a) {
			wls1.setPosition(0.21);
		}
		
		else if (gamepad2.y) {
			wls1.setPosition(0.47);
		}
		
		//claw
		else if (gamepad2.right_bumper) {
			ccs0.setPosition(0.1);
		}
		
		else if (gamepad2.left_bumper) {
			ccs0.setPosition(0.8);
		}
		//spin
		else if (gamepad2.dpad_left) {
			crs2.setPosition(0);
		} else if (gamepad2.dpad_up) {
			crs2.setPosition(0.5);
		}
		
		else if (gamepad2.dpad_right) {
			crs2.setPosition(1);
		} else {
			crs2.setPosition(0.5);
		}
	}
	private void brake() {
		if (gamepad2.b) {
			ctHubViper0.setPower(0.3);
			expHubViper1.setPower(0.3);
		} 
	}
}