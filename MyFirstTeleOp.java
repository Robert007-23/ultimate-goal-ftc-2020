//this are the classes you need to import for this file to work
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "MyFirstTeleOp")//the @ Put the file in TeleOp mode and the "name = " tells the phone what name to belong to this file
public class MyFirstTeleOp extends LinearOpMode {
//speed
int rawSpeedMultiplier = 1;
//the motors that have been defined in your phones will be stated here
 private DcMotor leftbackDrive;
 private DcMotor rightbackDrive;
 private DcMotor leftfrontDrive;
 private DcMotor rightfrontDrive;


    @Override   // This
    public void runOpMode(){
    leftbackDrive = hardwareMap.get(DcMotor.class, "BLM"); 
    rightbackDrive = hardwareMap.get(DcMotor.class, "BRM");         
    leftfrontDrive = hardwareMap.get(DcMotor.class, "FLM");  
    rightfrontDrive = hardwareMap.get(DcMotor.class, "FRM");

    waitForStart();// this ask the phone for when you press the start button.

     while (opModeIsActive()){


       // double multiplier = Range.clip(rawSpeedMultiplier - gamepad1.right_trigger, 2, 1);  

        //Arcade drive part of it: THe left stick controls speed while the right stick controls direction 
        double leftPower = Range.clip(gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1); 
        double rightPower = Range.clip(gamepad1.left_stick_y + gamepad1.right_stick_x,-1 ,1); 

       // leftbackDrive.setPower(leftPower * multiplier);
        //leftfrontDrive.setPower(leftPower * multiplier);
        //rightbackDrive.setPower(rightPower * multiplier);
        //rightfrontDrive.setPower(rightPower * multiplier);    

        leftbackDrive.setPower(leftPower );
        leftfrontDrive.setPower(leftPower );
        rightbackDrive.setPower(rightPower );
        rightfrontDrive.setPower(rightPower );

        if(gamepad1.a){

        leftbackDrive.setPower(1 );
        leftfrontDrive.setPower(1 );
        rightbackDrive.setPower(1 );
        rightfrontDrive.setPower(1 ); 
        }
     }   
    }
}
