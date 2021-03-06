package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.List;
import com.ufpr.tads.web2.beans.TipoAtendimentoBean;
import com.ufpr.tads.web2.dao.TipoAtendimentoDAO;

public class TipoAtendimentoFacade {
    public static final TipoAtendimentoDAO atendimentoDao = new TipoAtendimentoDAO();

    public static List<TipoAtendimentoBean> buscarTodosTiposAtendimentos() throws SQLException {
        List<TipoAtendimentoBean> listaTiposAtendimentos = atendimentoDao.all();
        return listaTiposAtendimentos;
    }

    public static TipoAtendimentoBean buscaTipoAtendimentoPorId(int id) throws SQLException {
        TipoAtendimentoBean tpAtendimento = atendimentoDao.buscarTipoAtendimentoPorId(id);
        return tpAtendimento;
    }
}
