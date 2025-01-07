// 
//  package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// 
// @TeleOp(name = "LinearSevoTest")
// public class LinearServoTest extends LinearOpMode {
// 
// 	private DcMotor leftmotor0;
// 	private DcMotor rightmotor1;
// 	private DcMotor frontleftmotor2;
// 	private DcMotor frontrightmotor3;
// 	private DcMotor VipSliMotor0;
// 	private DcMotor RightLinActMotor1;
// 	private DcMotor LeftLinActMotor2;
// 	private Servo VSlideServo0;
// 	private Servo ClawServo1;
// 	private Servo linearservo;
// 
// 	@Override
// 	public void runOpMode() {
// 		leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
// 		rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
// 		frontleftmotor2 = hardwareMap.get(DcMotor.class, "frontleftmotor2");
// 		frontrightmotor3 = hardwareMap.get(DcMotor.class, "frontrightmotor3");
// 		VipSliMotor0 = hardwareMap.get(DcMotor.class, "VipSliMotor0");
// 		RightLinActMotor1 = hardwareMap.get(DcMotor.class, "RightLinActMotor1");
// 		LeftLinActMotor2 = hardwareMap.get(DcMotor.class, "LeftLinActMotor2");
// 		VSlideServo0 = hardwareMap.get(Servo.class, "VSlideServo0");
// 		ClawServo1 = hardwareMap.get(Servo.class, "ClawServo1");
// 		linearservo = hardwareMap.get(Servo.class, "linearservo");
// 
// 		leftmotor0.setDirection(DcMotor.Direction.REVERSE);
// 		rightmotor1.setDirection(DcMotor.Direction.FORWARD);
// 		frontleftmotor2.setDirection(DcMotor.Direction.REVERSE);
// 		frontrightmotor3.setDirection(DcMotor.Direction.FORWARD);
// 		VipSliMotor0.setDirection(DcMotor.Direction.REVERSE);
// 		waitForStart();
// 		if (opModeIsActive()) {
// 			while (opModeIsActive()) {
// 				linservclaw();
// 			}
// 		}
// 	}
// 	
// 	private void linservclaw() {
// if(gamepad2.right_bumper) {
// 	linearservo.setPosition(1);
// }
// if(gamepad2.left_bumper) {
// 	linearservo.setPosition(0.95);
// }
// else {
// 	linearservo.setPosition(0.05);
// 	}
// }
// 
// 
// 	}