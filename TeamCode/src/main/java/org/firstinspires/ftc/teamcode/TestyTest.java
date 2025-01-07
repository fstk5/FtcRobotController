package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TestyTest", group="TeleOp")

public class TestyTest extends LinearOpMode {
	private Blinker control_Hub;
	private Blinker expansion_Hub_1;
	private DcMotor bl1;
	private DcMotor br0;
	private DcMotor clawLin2;
	private DcMotor ctHubViper0;
	private DcMotor extHubViper1;
	private DcMotor fl2;
	private DcMotor fr3;
	private IMU imu;
	private Servo sv0;
	private Servo sv1;
	
	// todo: write your code here
	
	@Override
	public void runOpMode() {
		if (opModeIsActive()) {
			
			int sv0Pos = 0;
			int sv1Pos = 0;
			
			while (gamepad1.a) {
				sv0Pos += 1;
			}
			
			while (gamepad1.b) {
				sv0Pos -= 1;
			}
			
			while (gamepad1.x) {
				sv1Pos += 1;
			}
			
			while (gamepad1.y) {
				sv1Pos -= 1;
			}
			
			sv0.setPosition(sv0Pos);
			sv1.setPosition(sv1Pos);
			
			ctHubViper0.setPower(gamepad1.right_stick_y);
			extHubViper1.setPower(gamepad1.left_stick_y);
			
		}
	}
	
	private void linAct(double speed){
		ctHubViper0.setPower(speed);
		extHubViper1.setPower(speed);
	}
}