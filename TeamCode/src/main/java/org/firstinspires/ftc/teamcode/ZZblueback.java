package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Disabled//(name = "ZZblueback")
public class ZZblueback extends LinearOpMode {
	
	private Servo ClawServo0;
	private Servo ClawServo1;
	private Servo front0;
	private Servo drone5;
	private Blinker grilled_hams;
	private IMU imu;
	private DcMotor leftmotor0;
	private DcMotor port0;
	private DcMotor port1;
	private DcMotor port2;
	private DcMotor port3;
	private DcMotor rightmotor1;
	private Blinker super_cool_expansion_thing;
	private DcMotor topleftmotor2;
	private DcMotor toprightmotor3;
	private DistanceSensor colorSensor1_DistanceSensor;
	//private ColorSensor colorSensor0;
	
  private int leftPos;
  private int armPos;
  private int rightPos;
  private int topleftPos;
  private int toprightPos;
  private int tick;
  private int pause;
  
  
  @Override
  public void runOpMode() {
	 int ClawServo1Pos;
	 int CurrentColor;
	 double Distance;
	 boolean cheddar;

	 leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
	 topleftmotor2 = hardwareMap.get(DcMotor.class, "topleftmotor2");
	 drone5 = hardwareMap.get(Servo.class, "drone5");
	 front0 = hardwareMap.get(Servo.class, "front0");
	 ClawServo1 = hardwareMap.get(Servo.class, "ClawServo1");
	 ClawServo0 = hardwareMap.get(Servo.class, "ClawServo0");
	 toprightmotor3 = hardwareMap.get(DcMotor.class, "toprightmotor3");
	 rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
	 port0 = hardwareMap.get(DcMotor.class, "port 0");
	 port2 = hardwareMap.get(DcMotor.class, "port 2");
	 //colorSensor0 = hardwareMap.get(ColorSensor.class, "colorSensor0");
	 colorSensor1_DistanceSensor = hardwareMap.get(DistanceSensor.class, "colorSensor1");
	 
	 leftmotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	 rightmotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	 topleftmotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	 toprightmotor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	 port0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	 port0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	 leftmotor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	 rightmotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	 topleftmotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	 toprightmotor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	 
	 leftPos = 0;
	 rightPos = 0;
	 topleftPos = 0;
	 toprightPos = 0;
	 tick = 300;
	 pause = 400;
	 Distance = 0;
	 cheddar = true;
	 armPos = 0;
	 front0.setPosition(-1);

	 waitForStart();
	 leftmotor0.setDirection(DcMotor.Direction.REVERSE);
	 topleftmotor2.setDirection(DcMotor.Direction.REVERSE);
	 drone5.setPosition(-0.3);
	 
	 ClawServo1Pos = 0;
	 
	 
	 
	 /**
	  560 ticks is one revolution/ one full spin of the wheel
	  for claw 1st number higher the number the more it closes, lower it opens
	  claw 2nd number moves wrist of claw, positive down negative up
	  negative numbers both wheels go forward, vise versa backwards
	  arm positive number goes down negative goes up
	  sleep(###)just pauses robot
	  positive for lin act goes out negative goes in
	  negative numbers are outside it slide left if they in middle slide right
	 */
	 
	 
	 
	 
if (opModeIsActive()) {
	//robot is 9.5 inches away before spikepixel - spikepixel is non-existant
			
		
	Distance = colorSensor1_DistanceSensor.getDistance(DistanceUnit.INCH);
	telemetry.addData("Distance", Distance);
	// first spike mark check
	sleep(pause);
	driveInches(2, 0.2);
	slydeInches(10, 0.2, true);
	driveInches(16, 0.4);
	driveInches(4, 0.1);
	sleep(pause);
	Distance = colorSensor1_DistanceSensor.getDistance(DistanceUnit.INCH);

	if (Distance < 2) {
		driveInches(-4.5, 0.3);
		slydeInches(5, 0.3, false);
		drone(true);
		driveInches(-2, 0.3);
	detect1();
		return;
		
	}
	// second spike mark check
	else {
		slydeInches(13.5, 0.5, false);
	sleep(pause);
	driveInches(6, 0.1);
	sleep(pause);
	Distance = colorSensor1_DistanceSensor.getDistance(DistanceUnit.INCH);
	telemetry.update();
	
	}
	
	if (Distance < 2){
		driveInches(-2, 0.2);
		slydeInches(4, 0.4, true);
		drone(true);
		driveInches(-3, 0.2);
		detect2();
		end();
	}
	// last spike mark check 
	else {
	spin(90, 0.7, false);
	sleep(pause);
	driveInches(1.5, .3);
	slydeInches(4, .4, false);
	drone(true);
	driveInches(-3, .3);
	sleep(pause);
	Distance = colorSensor1_DistanceSensor.getDistance(DistanceUnit.INCH);
	detected3();
	}

	
			}
		}
  
  private void end() {
  	return;
  }
  private void detected3() {
  		spin(180, 0.5, true);
  		sleep(pause);
  		driveInches(31.5, 0.5);
  		slydeInches(11, 0.2, false);
  		wrist(3000, true);
  		sleep(pause);
  		arm(800, 0.4);
  		sleep(pause);
  		ClawServo0.setPosition(0.4);
  		sleep(pause);
  		driveInches(-7, 0.1);
  		arm(-400, 1);
  		slydeInches(40, 0.6, true);
  		driveInches(13, 0.6);
  }
  private void detect2() {
  	spin(90, 0.5, true);
  	sleep(pause);
  	driveInches(31.5, 0.5);
  	sleep(1);
  	slydeInches(2, 0.5, false);
  	wrist(3000, true);
	sleep(pause);
	arm(800, 0.3);
	sleep(pause);
  	ClawServo0.setPosition(0.4);
  	sleep(pause);
  	driveInches(-4, 0.2);
  	arm(-400, 1);
  	slydeInches(29, 0.5, true);
  	driveInches(12, 0.5);
  	
  	
  }
  
  private void detect1(){
  	spin(90, 0.5, true);
  	sleep(pause);
  	driveInches(19, 0.5);
  	slydeInches(10, 0.5, false);
  	driveInches(6, 0.5);
  	sleep(1);
  	wrist(3000, true);
	sleep(pause);
	arm(800, 0.3);
	sleep(pause);
  	ClawServo0.setPosition(0.4);
  	sleep(pause);
  	driveInches(-4, 0.2);
  	arm(-400, 1);
  	slydeInches(22, 0.5, true);
  	driveInches(15, 0.5);
  	
  }
  
  
  private void spin(double degrees, double power, boolean left){
  	double ticksperdegree = 10.2;
  	double degreeticktarget = degrees*ticksperdegree;
  	
  	leftmotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	rightmotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	topleftmotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	toprightmotor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  	
  	if(!left){
  	leftmotor0.setTargetPosition(-(int)degreeticktarget);
	topleftmotor2.setTargetPosition(-(int)degreeticktarget);
	rightmotor1.setTargetPosition((int)degreeticktarget);
	toprightmotor3.setTargetPosition((int)degreeticktarget);
	
	leftmotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	topleftmotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	toprightmotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	rightmotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  		
  	}
  	
  	else{
  	leftmotor0.setTargetPosition((int)degreeticktarget);
	topleftmotor2.setTargetPosition((int)degreeticktarget);
	rightmotor1.setTargetPosition(-(int)degreeticktarget);
	toprightmotor3.setTargetPosition(-(int)degreeticktarget);
	
	leftmotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	topleftmotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	toprightmotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	rightmotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  		
  	}
  	
  	leftmotor0.setPower(power);
	rightmotor1.setPower(power);
	topleftmotor2.setPower(power);
	toprightmotor3.setPower(power);
	
	while(toprightmotor3.isBusy()){}
	leftmotor0.setPower(0);
	rightmotor1.setPower(0);
	topleftmotor2.setPower(0);
	toprightmotor3.setPower(0);
  
  }
  
  
  private void slydeInches(double inches, double power, boolean Left){
	double circumfrence = 3.78;
	double leftMotorPos;
	double rightMotorPos;
	double topMotorleftPos;
	double topMotorrightPos;
	double ticksperin = 43.78;
	
	leftmotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	rightmotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	topleftmotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	toprightmotor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

	if (!Left){
		leftMotorPos = -inches * ticksperin;
		rightMotorPos = inches  * ticksperin;
		topMotorleftPos = inches * ticksperin;
		topMotorrightPos = -inches * ticksperin;
	}
	else {
		leftMotorPos = inches * ticksperin;
		rightMotorPos = -inches  * ticksperin;
		topMotorleftPos = -inches * ticksperin;
		topMotorrightPos = inches  * ticksperin;
	}

	
	//pos = pos + target
	
	leftmotor0.setTargetPosition(-(int)topMotorleftPos);
	topleftmotor2.setTargetPosition(-(int)leftMotorPos);
	rightmotor1.setTargetPosition(-(int)rightMotorPos);
	toprightmotor3.setTargetPosition(-(int)topMotorrightPos);
	
	leftmotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	topleftmotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	toprightmotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	rightmotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

	leftmotor0.setPower(power);
	rightmotor1.setPower(power);
	topleftmotor2.setPower(power);
	toprightmotor3.setPower(power);
	
	while(toprightmotor3.isBusy()){}
	leftmotor0.setPower(0);
	rightmotor1.setPower(0);
	topleftmotor2.setPower(0);
	toprightmotor3.setPower(0);
	
  }

  public void driveInches(double inches, double power){
	double circumfrence = 3.78;
	double leftMotorPos;
	double rightMotorPos;
	double topMotorleftPos;
	double topMotorrightPos;
	double ticksperin = 43.78;
	
	leftmotor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	rightmotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	topleftmotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	toprightmotor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

	leftMotorPos = inches * ticksperin;
	rightMotorPos = inches * ticksperin;
	topMotorleftPos = inches  * ticksperin;
	topMotorrightPos = inches  * ticksperin;
	
	leftmotor0.setTargetPosition((int)-topMotorleftPos);
	topleftmotor2.setTargetPosition((int)-leftMotorPos);
	rightmotor1.setTargetPosition((int)-rightMotorPos);
	toprightmotor3.setTargetPosition((int)-topMotorrightPos);
	
	leftmotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	topleftmotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	toprightmotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	rightmotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

	leftmotor0.setPower(power);
	rightmotor1.setPower(power);
	topleftmotor2.setPower(power);
	toprightmotor3.setPower(power);

	while(toprightmotor3.isBusy()){}
	leftmotor0.setPower(0);
	rightmotor1.setPower(0);
	topleftmotor2.setPower(0);
	toprightmotor3.setPower(0);
  }

 private void drive(double leftTarget, double topleftTarget,
 double rightTarget, double toprightTarget, double speed) {
	  
	leftPos += leftTarget;
	rightPos += rightTarget;
	topleftPos += topleftTarget;
	toprightPos += toprightTarget;
	
	//pos = pos + target
	
	leftmotor0.setTargetPosition(topleftPos);
	topleftmotor2.setTargetPosition(leftPos);
	rightmotor1.setTargetPosition(rightPos);
	toprightmotor3.setTargetPosition(toprightPos);
	
	leftmotor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	topleftmotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	toprightmotor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	rightmotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	
	leftmotor0.setPower(speed);
	topleftmotor2.setPower(speed);
	rightmotor1.setPower(speed);
	toprightmotor3.setPower(speed);
	
	while(opModeIsActive() && leftmotor0.isBusy() && rightmotor1.isBusy() && 
	topleftmotor2.isBusy() && toprightmotor3.isBusy()) {
	  idle();
	  
	}
 }
	
	private void linactmotor(double speed, double time2) {
	 // Operates length of the linear actuator
	 time2=time2*1000;
	 port2.setPower(speed);
	 sleep((long) time2);
	 fullStop();
  }
 
 
private void wrist(long time, boolean up) {
	if (up) {
		ClawServo1.setPosition(0);
		sleep(time);
		ClawServo1.setPosition(.5);
	}
	
	else{
		ClawServo1.setPosition(1);
		sleep(time);
		ClawServo1.setPosition(.5);
	}
}
 private void drone(boolean open) {
 	if (open = true){
 		front0.setPosition(0.5);
 		sleep(1000);
 		front0.setPosition(-1);
 		}
 }

 private void finger(boolean open) {
 	if (open) {
 		ClawServo0.setPosition(0.4);
 	}
 	else {
 		ClawServo0.setPosition(1);
 		}
  }

  private void fullStop() {
	 // stops
	 leftmotor0.setPower(0);
	 rightmotor1.setPower(0);
	 topleftmotor2.setPower(0);
	 toprightmotor3.setPower(0);
	 port2.setPower(0);
	 port0.setPower(0);
  }
  private void arm(int target, double speed){
	
	port0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
	//pos = pos + target
	
	port0.setTargetPosition(target);
	
	port0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	
	
	port0.setPower(speed);
	
	while(opModeIsActive() && port0.isBusy()) {
	  idle();
	  
		}
	}
}
