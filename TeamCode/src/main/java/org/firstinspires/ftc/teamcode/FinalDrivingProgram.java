// package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// 
// @TeleOp(name = "FinalDrivingProgram")
// public class FinalDrivingProgram extends LinearOpMode {
// 
//   private DcMotor leftmotor0;
//   private DcMotor topleftmotor2;
//   private Servo drone5;
//   private Servo ClawServo1;
//   private Servo ClawServo0;
//   private DcMotor toprightmotor3;
//   private DcMotor rightmotor1;
//   private DcMotor port0;
//   private DcMotor port2;
// 
//   /**
//	* Describe this function...
//	*/
//   @Override
//   public void runOpMode() {
// 	int ClawServo1Pos;
// 
// 	leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
// 	topleftmotor2 = hardwareMap.get(DcMotor.class, "topleftmotor2");
// 	drone5 = hardwareMap.get(Servo.class, "drone5");
// 	ClawServo1 = hardwareMap.get(Servo.class, "ClawServo1");
// 	ClawServo0 = hardwareMap.get(Servo.class, "ClawServo0");
// 	toprightmotor3 = hardwareMap.get(DcMotor.class, "toprightmotor3");
// 	rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
// 	port0 = hardwareMap.get(DcMotor.class, "port 0");
// 	port2 = hardwareMap.get(DcMotor.class, "port 2");
// 
// 	waitForStart();
// 	leftmotor0.setDirection(DcMotor.Direction.REVERSE);
// 	topleftmotor2.setDirection(DcMotor.Direction.REVERSE);
// 	drone5.setPosition(0.2);
// 	ClawServo1Pos = 0;
// 	//TOP LEFT MOTOR AND LEFT MOTOR ARE SWITCHED - TOP LEFT MOTOR IS
// 	//BACK LEFT MOTOR WHILE LEFT MOTOR IS TOP LEFT MOTOR >>>L>:L>>
// 	while (opModeIsActive()) {
// 	  forward();
// 	  backward();
// 	  slide();
// 	  turn();
// 	  Linearact();
// 	  Arm();
// 	  wrist();
// 	  claw2();
// 	  droneLaunch();
// 	  telemetry.addLine(leftmotor0.getCurrentPosition()+"");
// 	  telemetry.addLine(rightmotor1.getCurrentPosition()+"");
// 	  telemetry.addLine(topleftmotor2.getCurrentPosition()+"");
// 	  telemetry.addLine(toprightmotor3.getCurrentPosition()+"");
// 	  telemetry.update();
// 	}
//  }
// 
//   private void wrist() {
// 	//continous servo - 0.5 is resting 
// 	if(gamepad2.x){
// 		ClawServo1.setPosition(0);
// 	}
// 	
// 	else if (gamepad2.a){
// 		ClawServo1.setPosition(1);
// 	}
// 	
// 	else{
// 		ClawServo1.setPosition(0.5);
// 	}
// }
// 
// 
// 
//   /**
//	* Describe this function...
//	*/
//   private void claw2() {
// 	double ClawServo0Pos=0;
// 
// 
// 	if (gamepad2.right_bumper) {
// 	  ClawServo0Pos = 0.4;
// 	  ClawServo0.setPosition(ClawServo0Pos);
// 	} else if (gamepad2.left_bumper) {
// 	  ClawServo0Pos = 1;
// 	  ClawServo0.setPosition(ClawServo0Pos);
// 	} 
//   }
// 
//   private void turn() {
// 	leftmotor0.setPower(gamepad1.left_stick_x * -0.8);
// 	topleftmotor2.setPower(gamepad1.left_stick_x * -0.8);
// 	toprightmotor3.setPower(gamepad1.left_stick_x * 0.75);
// 	rightmotor1.setPower(gamepad1.left_stick_x * 0.75);
//   }
// 
//   /**
//	* Describe this function...
//	*/
//   private void Arm() {
// 	port0.setPower(gamepad2.left_stick_y * -0.5);
//   }
// 
//   /**
//	* Describe this function...
//	*/
//   private void Linearact() {
// 	port2.setPower(gamepad2.right_stick_y * -1);
//   }
// 
//   /**
//	* Describe this function...
//	*/
//   private void slide() {
// 	
// 	if (gamepad1.right_stick_x < -0.5){
// 	  leftmotor0.setPower(0.8);
// 	  rightmotor1.setPower(0.8);
// 	  topleftmotor2.setPower(-0.9);
// 	  toprightmotor3.setPower(-1);
// 	  }
// 	  
// 	else if (gamepad1.right_stick_x > 0.5){
// 	  leftmotor0.setPower(-0.8);
// 	  rightmotor1.setPower(-0.8);
// 	  topleftmotor2.setPower(0.9);
// 	  toprightmotor3.setPower(1);
// 	  }
// 	  
// 	  if (gamepad1.right_stick_x < 0){
// 	  leftmotor0.setPower(0.5);
// 	  rightmotor1.setPower(0.5);
// 	  topleftmotor2.setPower(-0.6);
// 	  toprightmotor3.setPower(-0.7);
// 	  }
// 	  
// 	else if (gamepad1.right_stick_x > 0){
// 	  leftmotor0.setPower(-0.5);
// 	  rightmotor1.setPower(-0.5);
// 	  topleftmotor2.setPower(0.6);
// 	  toprightmotor3.setPower(0.7);
// 	  }
// 	  
// 	  else{
// 	  leftmotor0.setPower(0);
// 	  rightmotor1.setPower(0);
// 	  topleftmotor2.setPower(0);
// 	  toprightmotor3.setPower(0);
// 	  }
// 	
// 	/**
// 	leftmotor0.setPower(gamepad1.right_stick_x * 0.5);
// 	rightmotor1.setPower(gamepad1.right_stick_x * 0.5);
// 	topleftmotor2.setPower(gamepad1.right_stick_x * -0.5);
// 	toprightmotor3.setPower(gamepad1.right_stick_x * -0.5);
// 	*/
// 
//	
//   }
// 
//   /**
//	* Describe this function...
//	*/
//   private void backward() {
// 	//Front left wheel
// 	leftmotor0.setPower(gamepad1.left_trigger * 0.9);
// 	//Back right wheel
// 	rightmotor1.setPower(gamepad1.left_trigger * 0.85);
// 	//Back left wheel
// 	topleftmotor2.setPower(gamepad1.left_trigger * 0.9);
// 	//Front right wheel
// 	toprightmotor3.setPower(gamepad1.left_trigger * 0.85);
// 	
// 	/**
// 	 //Drive forward
// 	 if (gamepad1.right_stick_y > 0){
// 	  leftmotor0.setPower(0.5);
// 	  rightmotor1.setPower(0.5);
// 	  topleftmotor2.setPower(0.7);
// 	  toprightmotor3.setPower(0.5);
// 	  }
// 	
// 	//Drive backward  
// 	else if (gamepad1.right_stick_y < 0){
// 	  leftmotor0.setPower(-0.5);
// 	  rightmotor1.setPower(-0.5);
// 	  topleftmotor2.setPower(-0.7);
// 	  toprightmotor3.setPower(-0.5);
// 	  }
// 	  
// 	//Shutoff power
// 	  else{
// 	  leftmotor0.setPower(0);
// 	  rightmotor1.setPower(0);
// 	  topleftmotor2.setPower(0);
// 	  toprightmotor3.setPower(0);
// 	  }
// 	**/
//   }
// 
//   /**
//	* Describe this function...
//	* leftmotor0 = Front Left
//	* rightotor1 = Back Right
//	* topleftmotor2 = Back Left
//	* toprightmotor3 = Front Right
//	*/
//   private void forward() {
// 	//Front left wheel
// 	leftmotor0.setPower(gamepad1.right_trigger * -0.9);
// 	//Back right wheel
// 	rightmotor1.setPower(gamepad1.right_trigger * -0.85);
// 	//Back left wheel
// 	topleftmotor2.setPower(gamepad1.right_trigger * -0.9);
// 	//Front right wheel
// 	toprightmotor3.setPower(gamepad1.right_trigger * -0.85);
//   }
// 
//   /**
//	* Describe this function...
//	*/
//   private void droneLaunch() {
// 	if (gamepad1.a) {
// 	  drone5.setPosition(-0.3);
// 	} else {
// 	  drone5.setPosition(0.2);
// 	}
//  }
// }
// 