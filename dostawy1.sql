select z.id from zlecenia z 
   left join  zamowienia_materialow zm on z.id = zm.zlecenie_id;