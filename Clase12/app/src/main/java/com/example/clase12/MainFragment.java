package com.example.clase12;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase12.AlumnoAdapter;
import com.example.clase12.AsistenciaAdapter;
import com.example.clase12.CursoAdapter;
import com.example.clase12.AlumnoDao;
import com.example.clase12.AsistenciaDao;
import com.example.clase12.CursoDao;
import com.example.clase12.Alumno;
import com.example.clase12.Asistencia;
import com.example.clase12.Curso;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView rvCursos, rvAlumnos, rvAsistencias;
    CursoDao cursoDao;
    AlumnoDao alumnoDao;
    AsistenciaDao asistenciaDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppDatabase db = AppDatabase.getInstance(requireContext());
        cursoDao = db.cursoDao();
        alumnoDao = db.alumnoDao();
        asistenciaDao = db.asistenciaDao();

        rvCursos = view.findViewById(R.id.rvCursos);
        rvAlumnos = view.findViewById(R.id.rvAlumnos);
        rvAsistencias = view.findViewById(R.id.rvAsistencias);

        rvCursos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAlumnos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAsistencias.setLayoutManager(new LinearLayoutManager(getContext()));

        insertarDatosDePrueba();

        cargarCursos();
    }


    private void insertarDatosDePrueba() {
        if (cursoDao.obtenerTodos().isEmpty()) {

            Curso c1 = new Curso();
            c1.clave = "MAT01";
            c1.nombre = "Matemáticas";
            cursoDao.insertar(c1);

            Curso c2 = new Curso();
            c2.clave = "FIS01";
            c2.nombre = "Física";
            cursoDao.insertar(c2);

            Curso c3 = new Curso();
            c3.clave = "PRG01";
            c3.nombre = "Programación";
            cursoDao.insertar(c3);

            List<Curso> cursos = cursoDao.obtenerTodos();
            int idMat = cursos.get(0).id;
            int idFis = cursos.get(1).id;
            int idPrg = cursos.get(2).id;

            Alumno a1 = new Alumno();
            a1.nombre = "Josefina";
            a1.apellidoPaterno = "García";
            a1.apellidoMaterno = "López";
            a1.cursoId = idMat;
            alumnoDao.insertar(a1);

            Alumno a2 = new Alumno();
            a2.nombre = "Mario";
            a2.apellidoPaterno = "Hernández";
            a2.apellidoMaterno = "Ruiz";
            a2.cursoId = idMat;
            alumnoDao.insertar(a2);

            Alumno a3 = new Alumno();
            a3.nombre = "Lucía";
            a3.apellidoPaterno = "Ramírez";
            a3.apellidoMaterno = "Torres";
            a3.cursoId = idMat;
            alumnoDao.insertar(a3);

            Alumno a4 = new Alumno();
            a4.nombre = "Ana";
            a4.apellidoPaterno = "Martínez";
            a4.apellidoMaterno = "Soto";
            a4.cursoId = idFis;
            alumnoDao.insertar(a4);

            Alumno a5 = new Alumno();
            a5.nombre = "Carlos";
            a5.apellidoPaterno = "Pérez";
            a5.apellidoMaterno = "Vega";
            a5.cursoId = idFis;
            alumnoDao.insertar(a5);

            Alumno a6 = new Alumno();
            a6.nombre = "Sofía";
            a6.apellidoPaterno = "Luna";
            a6.apellidoMaterno = "Cruz";
            a6.cursoId = idFis;
            alumnoDao.insertar(a6);

            Alumno a7 = new Alumno();
            a7.nombre = "Diego";
            a7.apellidoPaterno = "Flores";
            a7.apellidoMaterno = "Mora";
            a7.cursoId = idPrg;
            alumnoDao.insertar(a7);

            Alumno a8 = new Alumno();
            a8.nombre = "Valeria";
            a8.apellidoPaterno = "Reyes";
            a8.apellidoMaterno = "Núñez";
            a8.cursoId = idPrg;
            alumnoDao.insertar(a8);

            Alumno a9 = new Alumno();
            a9.nombre = "Roberto";
            a9.apellidoPaterno = "Jiménez";
            a9.apellidoMaterno = "Campos";
            a9.cursoId = idPrg;
            alumnoDao.insertar(a9);

            int idJosefina = alumnoDao.obtenerPorCurso(idMat).get(0).id;
            int idMario    = alumnoDao.obtenerPorCurso(idMat).get(1).id;
            int idLucia    = alumnoDao.obtenerPorCurso(idMat).get(2).id;
            int idAna      = alumnoDao.obtenerPorCurso(idFis).get(0).id;
            int idCarlos   = alumnoDao.obtenerPorCurso(idFis).get(1).id;
            int idSofia    = alumnoDao.obtenerPorCurso(idFis).get(2).id;
            int idDiego    = alumnoDao.obtenerPorCurso(idPrg).get(0).id;
            int idValeria  = alumnoDao.obtenerPorCurso(idPrg).get(1).id;
            int idRoberto  = alumnoDao.obtenerPorCurso(idPrg).get(2).id;

            String[] fechasJosefina = {"13 enero", "17 enero", "20 enero", "24 enero", "27 enero", "31 enero"};
            for (String f : fechasJosefina) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idJosefina;
                asistenciaDao.insertar(a);
            }

            String[] fechasMario = {"13 enero", "20 enero", "24 enero", "31 enero", "3 febrero"};
            for (String f : fechasMario) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idMario;
                asistenciaDao.insertar(a);
            }

            String[] fechasLucia = {"17 enero", "24 enero", "27 enero", "3 febrero", "7 febrero", "10 febrero"};
            for (String f : fechasLucia) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idLucia;
                asistenciaDao.insertar(a);
            }

            String[] fechasAna = {"13 enero", "17 enero", "27 enero", "3 febrero", "10 febrero"};
            for (String f : fechasAna) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idAna;
                asistenciaDao.insertar(a);
            }

            String[] fechasCarlos = {"13 enero", "20 enero", "24 enero", "27 enero", "31 enero", "7 febrero"};
            for (String f : fechasCarlos) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idCarlos;
                asistenciaDao.insertar(a);
            }

            String[] fechasSofia = {"17 enero", "20 enero", "31 enero", "3 febrero", "10 febrero"};
            for (String f : fechasSofia) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idSofia;
                asistenciaDao.insertar(a);
            }

            String[] fechasDiego = {"13 enero", "17 enero", "20 enero", "24 enero", "7 febrero", "10 febrero"};
            for (String f : fechasDiego) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idDiego;
                asistenciaDao.insertar(a);
            }

            String[] fechasValeria = {"13 enero", "27 enero", "31 enero", "3 febrero", "7 febrero"};
            for (String f : fechasValeria) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idValeria;
                asistenciaDao.insertar(a);
            }

            String[] fechasRoberto = {"17 enero", "20 enero", "24 enero", "31 enero", "3 febrero", "10 febrero"};
            for (String f : fechasRoberto) {
                Asistencia a = new Asistencia(); a.fecha = f; a.alumnoId = idRoberto;
                asistenciaDao.insertar(a);
            }
        }
    }
    private void cargarCursos() {
        List<Curso> cursos = cursoDao.obtenerTodos();

        CursoAdapter adapter = new CursoAdapter(cursos, curso -> {
            cargarAlumnos(curso.id);
            rvAsistencias.setAdapter(new AsistenciaAdapter(new ArrayList<>()));
        });

        rvCursos.setAdapter(adapter);
    }

    private void cargarAlumnos(int cursoId) {
        List<Alumno> alumnos = alumnoDao.obtenerPorCurso(cursoId);

        AlumnoAdapter adapter = new AlumnoAdapter(alumnos, alumno -> {
            cargarAsistencias(alumno.id);
        });

        rvAlumnos.setAdapter(adapter);
    }

    private void cargarAsistencias(int alumnoId) {
        List<Asistencia> asistencias = asistenciaDao.obtenerPorAlumno(alumnoId);
        rvAsistencias.setAdapter(new AsistenciaAdapter(asistencias));
    }
}