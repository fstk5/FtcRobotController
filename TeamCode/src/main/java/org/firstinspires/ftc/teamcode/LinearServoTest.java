//  
//   package org.firstinspires.ftc.teamcode;
//  
//  import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//  import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//  import com.qualcomm.robotcore.hardware.DcMotor;
//  import com.qualcomm.robotcore.hardware.Servo;
//  
//  @TeleOp(name = "LinearServoTest")
//  public class LinearServoTest extends LinearOpMode {
//  
//  
//  	private Servo wls2;
//  
//  	@Override
//  	public void runOpMode() {
//  	
//  		wls2 = hardwareMap.get(Servo.class, "wls2");
//  
//  		waitForStart();
//  		if (opModeIsActive()) {
//  			while (opModeIsActive()) {
//  				linservclaw();
//  			}
//  		}
//  	}
//  	
//  	private void linservclaw() {
//  if(gamepad2.x) {
//  	wls2.setPosition(0.7);
//  }
//  else if(gamepad2.b) {
//  	wls2.setPosition(0.05);
//  }
//  else if(gamepad2.a){
// 	 wls2.setPosition(0.5);
//  }
//  
//  }
//  
//  
//  	}