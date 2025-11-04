package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TeleOpDrive")

public class TeleOpDrive extends OpMode {

	public DcMotor fl0;
	public DcMotor fr1;
	public DcMotor bl2;
	public DcMotor br3;
	
	@Override
	public void init() {
		
		// fl0 must be negative for forward
		// fr1 must be negative for forward
		// bl2 must be positive for forward
		// br3 must be positive for forward
		fl0 = hardwareMap.get(DcMotor.class, "fl0");
		fr1 = hardwareMap.get(DcMotor.class, "fr1");
		bl2 = hardwareMap.get(DcMotor.class, "bl2");
		br3 = hardwareMap.get(DcMotor.class, "br3");
		
		fl0.setDirection(DcMotor.Direction.FORWARD);
		fr1.setDirection(DcMotor.Direction.FORWARD);
		bl2.setDirection(DcMotor.Direction.FORWARD);
		br3.setDirection(DcMotor.Direction.FORWARD);
		
	}
	
	@Override
	public void loop() {
		
		Movement movement = new Movement();
		
		movement.drive();
		movement.slide();
		movement.rotation();
		
	}
	
	private class Movement {
		
		public void drive() {
			
			fl0.setPower(-(gamepad1.right_trigger-gamepad1.left_trigger));
			fr1.setPower(-(gamepad1.right_trigger-gamepad1.left_trigger));
			bl2.setPower(gamepad1.right_trigger-gamepad1.left_trigger);
			br3.setPower(gamepad1.right_trigger-gamepad1.left_trigger);
			
		}
		
		public void slide() {
			
			fl0.setPower(-gamepad1.right_stick_x);
			fr1.setPower(gamepad1.right_stick_x);
			bl2.setPower(-gamepad1.right_stick_x);
			br3.setPower(gamepad1.right_stick_x);
			
		}
		
		public void rotation() {
			
			fl0.setPower(-gamepad1.left_stick_x);
			fr1.setPower(-gamepad1.left_stick_x);
			bl2.setPower(-gamepad1.left_stick_x);
			br3.setPower(-gamepad1.left_stick_x);
			
		}
	}
}
