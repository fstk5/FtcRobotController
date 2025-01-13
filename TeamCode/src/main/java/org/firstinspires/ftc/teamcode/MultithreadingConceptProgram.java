package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "MCP")
public class MultithreadingConceptProgram extends LinearOpMode {
	
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
	private boolean tempVar;
	
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
		//ccs0.setDirection(Servo.Direction.FORWARD);
		//crs2.setDirection(Servo.Direction.FORWARD);
		
		
		br0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		bl1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		fl2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		fr3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		ctHubViper0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		expHubViper1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		
		btrue = false;
		
		waitForStart();
		
		if (opModeIsActive()) {
			multithreading thread = new multithreading();
			thread.start();
		}
	}
	
	private class multithreading extends Thread {
		@Override
		public void run() {
			ctHubViper0.setPower(0.3);
			expHubViper1.setPower(0.3);
		}
	}
}