@Library('wolox-ci')
import com.wolox.*;

def call(ProjectConfiguration projectConfig, def nextClosure) {
    return { variables ->
        /* Build redis image */
        docker.image('redis').withRun() { redis ->
            withEnv(["REDIS_URL=redis://redis"]) {
                variables.redis = redis;
                nextClosure(variables)
            }
        }
    }
}
