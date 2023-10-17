import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
    vus: 100,
    duration: '60s',
};

export default function () {
    let response = http.post('http://numble.com:8080/site/visitor?siteRootPath=loadTest6');

    check(response, {
        'is status 200': (r) => r.status === 200,
    });

    sleep(1);
}