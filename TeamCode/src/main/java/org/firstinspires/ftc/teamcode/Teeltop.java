// package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// 
// @TeleOp(name = "Teeltop")
// public class Teeltop extends LinearOpMode {
// 
// private DcMotor br0;
// private DcMotor bl1;
// private DcMotor fl2;
// private DcMotor fr3;
// private Servo ccs0;
// 
// 
// @Override
// public void runOpMode() {
// br0 = hardwareMap.get(DcMotor.class, "br0");
// bl1 = hardwareMap.get(DcMotor.class, "bl1");
// fl2 = hardwareMap.get(DcMotor.class, "fl2");
// fr3 = hardwareMap.get(DcMotor.class, "fr3");
// ccs0 = hardwareMap.get(Servo.class, "ccs0");
// 
// 
// 
// 
// br0.setDirection(DcMotor.Direction.FORWARD);
// bl1.setDirection(DcMotor.Direction.REVERSE);
// fl2.setDirection(DcMotor.Direction.REVERSE);
// 
// 
// 
// br0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// bl1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// fl2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// fr3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
// 
// waitForStart();
// 
// while (opModeIsActive()) {
// forward();
// backward();
// turn();
// slide();
// 
// if (gamepad1.a){
// ccs0.setPosition(1);	
// }
// else if(gamepad1.b){
// 	ccs0.setPosition(0);
// }
// 
// 
// 		}
// 	
// }
// 
// private void forward() {
// br0.setPower(gamepad1.right_trigger * 0.85);
// bl1.setPower(gamepad1.right_trigger * 0.85);
// fl2.setPower(gamepad1.right_trigger * 0.85);
// fr3.setPower(gamepad1.right_trigger * 0.85);
// }
// 
// private void backward() {
// br0.setPower(gamepad1.left_trigger * -0.85);
// bl1.setPower(gamepad1.left_trigger * -0.85);
// fl2.setPower(gamepad1.left_trigger * -0.85);
// fr3.setPower(gamepad1.left_trigger * -0.85);
// }
// 
// private void turn() {
// br0.setPower(-gamepad1.left_stick_x);
// bl1.setPower(-gamepad1.left_stick_x);
// fl2.setPower(gamepad1.left_stick_x);
// fr3.setPower(gamepad1.left_stick_x);
// }
// 
// private void slide() {
// br0.setPower(gamepad1.right_stick_x);
// bl1.setPower(-gamepad1.right_stick_x);
// fl2.setPower(-gamepad1.right_stick_x);
// fr3.setPower(gamepad1.right_stick_x);
// }
// 
// // private void vslide() {
// // if (gamepad2.left_stick_y > 0.5) {
// // VipSliMotor0.setPower(-0.75);
// // }
// // else if (gamepad2.left_stick_y < -0.5) {
// // VipSliMotor0.setPower(1);
// // }
// // else {
// // VipSliMotor0.setPower(0);
// // }
// // }
// // private void clawoc() { //open close
// // if (gamepad2.right_trigger > .5){
// // ClawServo1.setPosition(0.7);
// // }else if (gamepad2.left_trigger > .5) {
// // ClawServo1.setPosition(0.03);
// // }
// // }
// //
// // private void toggle() {
// // telemetry.addData("atrue", atrue);
// // telemetry.addData("btrue", btrue);
// // telemetry.update();
// //
// //// if (gamepad2.b){
// //// //VipSliMotor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
// //// VipSliMotor0.setPower(0.075);
// ////
// //// //so much braining attempting to do a toggle for a -- if you hit a once it makes the viper slide BRAKE if you hit again then it is FLAOT
// //// }
// //// }
// //
// // private void clawud() { //up down (hold)
// // if(gamepad2.right_bumper) {
// // VSlideServo0.setPosition(0.45);
// // }
// // else if(gamepad2.left_bumper){
// // VSlideServo0.setPosition(0.4);
// // }
// // else{
// // VSlideServo0.setPosition(0);
// // }
// // }
// // private void linact12() {
// // if (gamepad1.y) {
// // LinActMotor2.setPower(1);
// // }
// //
// // else if (gamepad1.a) {
// // LinActMotor2.setPower(-1);
// // }
// //
// // else {
// // LinActMotor2.setPower(0);
// // }
// //
// // }
// 
// }
// 
// 