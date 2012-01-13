/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.service.impl;

import com.stripbandunk.alexvariasi.entity.Pengaturan;
import com.stripbandunk.alexvariasi.service.PengaturanService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
@Service
public class PengaturanServiceImpl implements PengaturanService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Pengaturan pengaturan) {
        sessionFactory.getCurrentSession().save(pengaturan);
    }

    @Override
    @Transactional(readOnly = true)
    public Pengaturan find(String kode) {
        return (Pengaturan) sessionFactory.getCurrentSession().get(Pengaturan.class, kode);
    }
}