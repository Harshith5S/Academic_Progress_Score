package Additional;


import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class PdfCreator extends AppCompatActivity {
    private static Bitmap bm;
    static Context context;


    public static void createTabluarPdfDoc(ArrayList dataList) {

       /* try {

            String path = Environment.getExternalStorageDirectory ( ).getPath ( ) + "/MyAPP/";
            String currentDateTimeString = DateFormat.getDateTimeInstance ( ).format ( new Date ( ) );
            File dir = new File ( path );
            if (!dir.exists ( ))
                dir.mkdirs ( );


            File file = new File ( dir, "My_PDF_" + new Date ( ) + ".pdf" );
            FileOutputStream fOut = null;
            fOut = new FileOutputStream ( file );

            Document document = new Document ( PageSize.A4 );
            //ProductData in TabularForm..................
            float[] columnWidths = {0.20f, 0.20f, 0.30f, 0.20f,};    *//*  ( 100/ 4)    *//*
            PdfPTable table = new PdfPTable ( columnWidths );
            table.setWidthPercentage ( 100f );
            table.getDefaultCell ( ).setVerticalAlignment ( Element.ALIGN_CENTER );
            //table.addCell("OrderId");
            //table.addCell("CustomerName");
            table.addCell ( "UserName" );
            table.addCell ( "off_No" );
            table.addCell ( "PhoneNo" );
            table.addCell ( "address" );


            table.setHeaderRows ( 1 );
            PdfPCell[] cells = table.getRow ( 0 ).getCells ( );
            for (int j = 0; j < cells.length; j++) {
                cells[j].setBackgroundColor ( BaseColor.LIGHT_GRAY );
            }


            for (int k = 0; k < dataList.size ( ); k++) {
                table.addCell ( dataList.get ( k ).toString ());

            }

            PdfWriter.getInstance ( document, fOut );
            document.open ( );
            document.add ( table );
            document.close ( );
        } catch (Exception e) {
            e.printStackTrace ( );
        }


    }

    @NonNull
    public static void createlogoPdf(ArrayList dataList,Context context) {

        try {
            //creating a logo and paragraph type pdf....
            String path = Environment.getExternalStorageDirectory ( ).getPath ( ) + "/MyAPP/";
            String currentDateTimeString = DateFormat.getDateTimeInstance ( ).format ( new Date ( ) );
            File dir = new File ( path );
            if (!dir.exists ( ))
                dir.mkdirs ( );


            File file = new File ( dir, "My_PDF_" + new Date ( ) + ".pdf" );
            FileOutputStream fOut = null;
            fOut = new FileOutputStream ( file );
            Document document = new Document ( PageSize.A4 );
            Resources res = context.getResources();
            Drawable d = res.getDrawable( R.drawable.logo);
            BitmapDrawable bitDw = ((BitmapDrawable) d);
            Bitmap bmp = bitDw.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream ();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image image = Image.getInstance(stream.toByteArray());
            image.setAlignment(Element.ALIGN_JUSTIFIED);
            Paragraph p1 = new Paragraph ( "UserName"+"   :  "+(String) dataList.get ( 0 ) );
            Paragraph p2 = new Paragraph ( "off_No"+"   :  "+(String) dataList.get ( 1 ) ) ;
            Paragraph p3 = new Paragraph ( "PhoneNo"+"   :  "+(String) dataList.get ( 2 ) );
            Paragraph p4 = new Paragraph ( "address"+"   :  "+(String) dataList.get ( 3 ) );
            p1.setAlignment ( p1.ALIGN_CENTER );
            p2.setAlignment ( p2.ALIGN_CENTER);
            p3.setAlignment ( p3.ALIGN_CENTER );
            p4.setAlignment ( p4.ALIGN_CENTER );
            PdfWriter.getInstance ( document, fOut );
            document.open ( );
            document.add ( new Chunk ( ) );
            document.add(image);
            document.add (p1 );
            document.add ( p2);
            document.add ( p3);
            document.add (p4 );
            document.close ( );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }*/
    }
}






