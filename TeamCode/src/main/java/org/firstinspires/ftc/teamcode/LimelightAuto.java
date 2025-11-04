package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLFieldMap;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@TeleOp(name = "LimelightAuto")
public class LimelightAuto extends OpMode {
	
	private AprilTagProcessor aprilTag;
	private Limelight3A ll3a;
	private DcMotor fl0;
	private DcMotor fr1;
	private DcMotor bl2;
	private DcMotor br3;
	
	private boolean isLimelightStarted = false;
	
	@Override
	public void init() {
		
		fl0 = hardwareMap.get(DcMotor.class, "fl0");
		fr1 = hardwareMap.get(DcMotor.class, "fr1");
		bl2 = hardwareMap.get(DcMotor.class, "bl2");
		br3 = hardwareMap.get(DcMotor.class, "br3");
		ll3a = hardwareMap.get(Limelight3A.class, "limelight");
		
		ll3a.pipelineSwitch(0);
		
	}
	
	@Override
	public void loop() {
		
		if (!isLimelightStarted) {
			ll3a.start();
			isLimelightStarted = true;
		}
		
		LLResult result = ll3a.getLatestResult();
		if (result != null && result.isValid()) {
			List<LLResultTypes.FiducialResult> detectedTags = result.getFiducialResults();
		}
		
		telemetry.update();
		
	}
	
	class Movement {
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