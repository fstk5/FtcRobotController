// /* package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// 
// @TeleOp(name = "TeleOpDrive")
// public class TeleOpDrive extends LinearOpMode {
// 
// 	private DcMotor leftmotor0;
// 	private DcMotor rightmotor1;
// 	private DcMotor frontleftmotor2;
// 	private DcMotor frontrightmotor3;
// 	private DcMotor VipSliMotor0;
// 	private Servo ArmServo0;
// 	private Servo ClawServo1;
// 
// 	@Override
// 	public void runOpMode() {
// 		leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
// 		rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
// 		frontleftmotor2 = hardwareMap.get(DcMotor.class, "frontleftmotor2");
// 		frontrightmotor3 = hardwareMap.get(DcMotor.class, "frontrightmotor3");
// 		VipSliMotor0 = hardwareMap.get(DcMotor.class, "VipSliMotor0");
// 		ArmServo0 = hardwareMap.get(Servo.class, "ArmServo0");
// 		ClawServo1 = hardwareMap.get(Servo.class, "ClawServo1");
// 
// 		leftmotor0.setDirection(DcMotor.Direction.REVERSE);
// 		rightmotor1.setDirection(DcMotor.Direction.FORWARD);
// 		frontleftmotor2.setDirection(DcMotor.Direction.REVERSE);
// 		frontrightmotor3.setDirection(DcMotor.Direction.FORWARD);
// 		VipSliMotor0.setDirection(DcMotor.Direction.REVERSE);
// 
// 		VipSliMotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
// 
// 		//define values
// 		double rtrigger = 0;
// 		double ltrigger = 0;
// 		double lstick = 0;
// 		double rstick = 0;
// 		double vslide = 0;
// 		boolean atrue = false;
// 
// 		waitForStart();
// 		if (opModeIsActive()) {
// 			while (opModeIsActive()) {
// 				values();
// 				forward();
// 				backward();
// 				turn();
// 				slide();
// 				vslide();
// 				telemetry();
// 				claw();
// 				toggle();
// 			}
// 		}
// 	}
// 
// 	private void telemtry() {
// 		telemetry.addData("ltrigger", ltrigger);
// 		telemetry.addData("rtrigger", rtrigger);
// 		telemetry.addData("lstick", lstick);
// 		telemetry.addData("rstick", rstick);
// 		telemetry.addData("lpower", leftmotor0.getPower());
// 		telemetry.addData("lpower", rightmotor1.getPower());
// 		telemetry.addData("lpower", frontleftmotor2.getPower());
// 		telemetry.addData("lpower", frontrightmotor3.getPower());
// 		telemetry.addData("vslide", vslide);
// 		telemetry.update();
// 	}
// 
// 	private void values() {
// 		rtrigger = gamepad1.right_trigger * 0.5;
// 		ltrigger = gamepad1.left_trigger * 0.5;
// 		rstick = gamepad1.right_stick_x;
// 		lstick = gamepad1.left_stick_y;
// 		vslide = VipSliMotor0.getCurrentPosition();
// 	}
// 
// 	private void forward() {
// 		leftmotor0.setPower(rtrigger);
// 		rightmotor1.setPower(rtrigger);
// 		frontleftmotor2.setPower(rtrigger);
// 		frontrightmotor3.setPower(rtrigger);
// 	}
// 
// 	private void backward() {
// 		leftmotor0.setPower(ltrigger);
// 		rightmotor1.setPower(ltrigger);
// 		frontleftmotor2.setPower(ltrigger);
// 		frontrightmotor3.setPower(ltrigger);
// 	}
// 
// 	private void turn() {
// 		leftmotor0.setPower(lstick);
// 		rightmotor1.setPower(-lstick);
// 		frontleftmotor2.setPower(lstick);
// 		frontrightmotor3.setPower(-lstick);
// 	}
// 
// 	private void slide() {
// 		leftmotor0.setPower(-rstick);
// 		rightmotor1.setPower(rstick);
// 		frontleftmotor2.setPower(rstick);
// 		frontrightmotor3.setPower(-rstick);
// 	}
// 
// 	private void claw() {
// 		if (gamepad1.y) {
// 			ArmServo0.setPosition();
// 		}else {
// 			ArmServo0.setPosition();
// 		}
// 		if (gamepad1.right_bumper){
// 			ClawServo1.setPosition();
// 		}
// 		if (gamepad1.left_bumper){
// 			ClawServo1.setPosition();
// 		}
// 	}
// 
// 	private void vslide() {
// 		//dpad is boolean
// 		if (gamepad1.dpad_up) {
// 			VipSliMotor0.setPower(0.5);
// 		}
// 		else if (gamepad1.dpad_down) {
// 			VipSliMotor0.setPower(-0.5);
// 		}
// 		else {
// 			VipSliMotor0.setPower(0);
// 		}
// 	}
// 
// 	private void toggle() {
// 		if (gamepad1.a){
// 		
// 			if (!atrue){
// 				VipSliMotor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
// 				atrue = true;
// 			} else {
// 				VipSliMotor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
// 				atrue = false;
// 			}
// 				//so much braining attempting to do a toggle for a -- if you hit a once it makes the viper slide BRAKE if you hit again then it is FLAOT
// 		}
// 	}
// 	
// 	*/
// 	
// 