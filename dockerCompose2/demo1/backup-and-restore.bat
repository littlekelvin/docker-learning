# back up /usr/res content to web.tar
docker run --rm --volumes-from webDemo1 -v d:\ITA\backup:/backup ubuntu bash -c "cd /usr/res && tar cvf /backup/web.tar ./"

# restore named volume
docker run --rm --volumes-from webDemo1 -v d:\ITA\backup:/backup ubuntu bash -c "cd /usr/res && tar xvf /backup/web.tar --strip 1"