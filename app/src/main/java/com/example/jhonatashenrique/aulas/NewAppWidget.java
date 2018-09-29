package com.example.jhonatashenrique.aulas;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import org.threeten.bp.*;

import com.example.jhonatashenrique.aulas.DAO.HorarioDAO;
import com.example.jhonatashenrique.aulas.DAO.MateriaDAO;
import com.example.jhonatashenrique.aulas.DAO.QuartaDAO;
import com.example.jhonatashenrique.aulas.DAO.QuintaDAO;
import com.example.jhonatashenrique.aulas.DAO.SegundaDAO;
import com.example.jhonatashenrique.aulas.DAO.SextaDAO;
import com.example.jhonatashenrique.aulas.DAO.TercaDAO;
import com.example.jhonatashenrique.aulas.Domain.Horario;
import com.example.jhonatashenrique.aulas.Domain.Quarta;
import com.example.jhonatashenrique.aulas.Domain.Quinta;
import com.example.jhonatashenrique.aulas.Domain.Segunda;
import com.example.jhonatashenrique.aulas.Domain.Sexta;
import com.example.jhonatashenrique.aulas.Domain.Terca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static android.text.TextUtils.isEmpty;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    Segunda segunda;
    Terca terca;
    Quarta quarta;
    Quinta quinta;
    Sexta sexta;
    Horario horario;
    HorarioDAO daoHorario;
    MateriaDAO daoMat;

    @SuppressLint("NewApi")
    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        segunda = new Segunda();
        terca = new Terca();
        quarta = new Quarta();
        quinta = new Quinta();
        sexta = new Sexta();
        horario = new Horario();
        daoHorario = new HorarioDAO(context);
        daoMat = new MateriaDAO(context);



        horario = daoHorario.buscarHorario();
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        int valor = cal.get(Calendar.DAY_OF_WEEK);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);

        LocalTime aula1 = null;
        LocalTime aula2 = null;
        LocalTime aula3 = null;
        LocalTime aula4 = null;
        LocalTime aula5 = null;
        LocalTime aula6 = null;

        if (!horario.getHorario1().equals("")) {
            aula1 = LocalTime.parse(horario.getHorario1());
        }
        if (!horario.getHorario2().equals("")) {
            aula2 = LocalTime.parse(horario.getHorario2());
        }
        if (!horario.getHorario3().equals("")) {
            aula3 = LocalTime.parse(horario.getHorario3());
        }
        if (!horario.getHorario4().equals("")) {
            aula4 = LocalTime.parse(horario.getHorario4());
        }
        if (!horario.getHorario5().equals("")) {
            aula5 = LocalTime.parse(horario.getHorario5());
        }
        if (!horario.getHorario6().equals("")) {
            aula6 = LocalTime.parse(horario.getHorario6());
        }

        LocalTime horaatual = LocalTime.of(hora,minuto);;

            if (valor >=2 && valor <=6) {
                if (horaatual.isAfter(aula1) && horaatual.isBefore(aula2)) {
                    CriarNotificacao(context);
                }
                if (horaatual.isAfter(aula2) && horaatual.isBefore(aula3)) {
                    CriarNotificacao(context);
                }
                if (horaatual.isAfter(aula3) && horaatual.isBefore(aula4)) {
                    CriarNotificacao(context);
                }
                if (horaatual.isAfter(aula4) && horaatual.isBefore(aula5)) {
                    CriarNotificacao(context);
                }
                if (horaatual.isAfter(aula5) && horaatual.isBefore(aula6)) {
                    CriarNotificacao(context);
                }
                if (aula6 != null){
                    if (horaatual.isAfter(aula6) && horaatual.isBefore(aula6.plusMinutes(50))) {
                        CriarNotificacao(context);
                    }
                }


        }

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

        if (valor == 2) {
            SegundaDAO segDAO = new SegundaDAO(context);
            segunda = segDAO.buscarSegunda();
            views.setTextViewText(R.id.txtwin, "Segunda-Feira");
            views.setTextViewText(R.id.txthorario1win, horario.getHorario1());
            views.setTextViewText(R.id.txthorario2win, horario.getHorario2());
            views.setTextViewText(R.id.txthorario3win, horario.getHorario3());
            views.setTextViewText(R.id.txthorario4win, horario.getHorario4());
            views.setTextViewText(R.id.txthorario5win, horario.getHorario5());
            views.setTextViewText(R.id.txthorario6win, horario.getHorario6());
            views.setTextViewText(R.id.txtaula1win, daoMat.buscarMateria(segunda.getAula1()).getNome());
            views.setTextViewText(R.id.txtaula2win, daoMat.buscarMateria(segunda.getAula2()).getNome());
            views.setTextViewText(R.id.txtaula3win, daoMat.buscarMateria(segunda.getAula3()).getNome());
            views.setTextViewText(R.id.txtaula4win, daoMat.buscarMateria(segunda.getAula4()).getNome());
            views.setTextViewText(R.id.txtaula5win, daoMat.buscarMateria(segunda.getAula5()).getNome());
            views.setTextViewText(R.id.txtaula6win, daoMat.buscarMateria(segunda.getAula6()).getNome());
        }else if (valor == 3){
            TercaDAO terDAO = new TercaDAO(context);
            terca = terDAO.buscarTerca();
            views.setTextViewText(R.id.txtwin, "Terça-Feira");
            views.setTextViewText(R.id.txthorario1win, horario.getHorario1());
            views.setTextViewText(R.id.txthorario2win, horario.getHorario2());
            views.setTextViewText(R.id.txthorario3win, horario.getHorario3());
            views.setTextViewText(R.id.txthorario4win, horario.getHorario4());
            views.setTextViewText(R.id.txthorario5win, horario.getHorario5());
            views.setTextViewText(R.id.txthorario6win, horario.getHorario6());
            views.setTextViewText(R.id.txtaula1win, daoMat.buscarMateria(terca.getAula1()).getNome());
            views.setTextViewText(R.id.txtaula2win, daoMat.buscarMateria(terca.getAula2()).getNome());
            views.setTextViewText(R.id.txtaula3win, daoMat.buscarMateria(terca.getAula3()).getNome());
            views.setTextViewText(R.id.txtaula4win, daoMat.buscarMateria(terca.getAula4()).getNome());
            views.setTextViewText(R.id.txtaula5win, daoMat.buscarMateria(terca.getAula5()).getNome());
            views.setTextViewText(R.id.txtaula6win, daoMat.buscarMateria(terca.getAula6()).getNome());

        }else if (valor == 4){
            QuartaDAO quarDAO = new QuartaDAO(context);
            quarta = quarDAO.buscarQuarta();
            views.setTextViewText(R.id.txtwin, "Quarta-Feira");
            views.setTextViewText(R.id.txthorario1win, horario.getHorario1());
            views.setTextViewText(R.id.txthorario2win, horario.getHorario2());
            views.setTextViewText(R.id.txthorario3win, horario.getHorario3());
            views.setTextViewText(R.id.txthorario4win, horario.getHorario4());
            views.setTextViewText(R.id.txthorario5win, horario.getHorario5());
            views.setTextViewText(R.id.txthorario6win, horario.getHorario6());
            views.setTextViewText(R.id.txtaula1win, daoMat.buscarMateria(quarta.getAula1()).getNome());
            views.setTextViewText(R.id.txtaula2win, daoMat.buscarMateria(quarta.getAula2()).getNome());
            views.setTextViewText(R.id.txtaula3win, daoMat.buscarMateria(quarta.getAula3()).getNome());
            views.setTextViewText(R.id.txtaula4win, daoMat.buscarMateria(quarta.getAula4()).getNome());
            views.setTextViewText(R.id.txtaula5win, daoMat.buscarMateria(quarta.getAula5()).getNome());
            views.setTextViewText(R.id.txtaula6win, daoMat.buscarMateria(quarta.getAula6()).getNome());
        }else if (valor == 5){
            QuintaDAO quinDAO = new QuintaDAO(context);
            quinta = quinDAO.buscarQuinta();
            views.setTextViewText(R.id.txtwin, "Quinta-Feira");
            views.setTextViewText(R.id.txthorario1win, horario.getHorario1());
            views.setTextViewText(R.id.txthorario2win, horario.getHorario2());
            views.setTextViewText(R.id.txthorario3win, horario.getHorario3());
            views.setTextViewText(R.id.txthorario4win, horario.getHorario4());
            views.setTextViewText(R.id.txthorario5win, horario.getHorario5());
            views.setTextViewText(R.id.txthorario6win, horario.getHorario6());
            views.setTextViewText(R.id.txtaula1win, daoMat.buscarMateria(quinta.getAula1()).getNome());
            views.setTextViewText(R.id.txtaula2win, daoMat.buscarMateria(quinta.getAula2()).getNome());
            views.setTextViewText(R.id.txtaula3win, daoMat.buscarMateria(quinta.getAula3()).getNome());
            views.setTextViewText(R.id.txtaula4win, daoMat.buscarMateria(quinta.getAula4()).getNome());
            views.setTextViewText(R.id.txtaula5win, daoMat.buscarMateria(quinta.getAula5()).getNome());
            views.setTextViewText(R.id.txtaula6win, daoMat.buscarMateria(quinta.getAula6()).getNome());
        }else {
            SextaDAO sexDAO = new SextaDAO(context);
            sexta = sexDAO.buscarSexta();
            views.setTextViewText(R.id.txtwin, "Sexta-Feira");
            views.setTextViewText(R.id.txthorario1win, horario.getHorario1());
            views.setTextViewText(R.id.txthorario2win, horario.getHorario2());
            views.setTextViewText(R.id.txthorario3win, horario.getHorario3());
            views.setTextViewText(R.id.txthorario4win, horario.getHorario4());
            views.setTextViewText(R.id.txthorario5win, horario.getHorario5());
            views.setTextViewText(R.id.txthorario6win, horario.getHorario6());
            views.setTextViewText(R.id.txtaula1win, daoMat.buscarMateria(sexta.getAula1()).getNome());
            views.setTextViewText(R.id.txtaula2win, daoMat.buscarMateria(sexta.getAula2()).getNome());
            views.setTextViewText(R.id.txtaula3win, daoMat.buscarMateria(sexta.getAula3()).getNome());
            views.setTextViewText(R.id.txtaula4win, daoMat.buscarMateria(sexta.getAula4()).getNome());
            views.setTextViewText(R.id.txtaula5win, daoMat.buscarMateria(sexta.getAula5()).getNome());
            views.setTextViewText(R.id.txtaula6win, daoMat.buscarMateria(sexta.getAula6()).getNome());

        }
        Log.i("appWidgetId: ", ""+appWidgetId);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @SuppressWarnings("deprecation")
    public void CriarNotificacao(Context context){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.notificacao)
                        .setContentTitle("Check-In da Aula")
                        .setContentText("Não se esqueça de fazer o seu Check-In na aula");
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, Principal.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(Principal.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());
        Log.i("teste","Fez toda a operacao da not");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

